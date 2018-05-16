package com.chinazyjr.githubapplication.utils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class RxBusHelper {
    /**
     * 发布消息
     *
     * @param o
     */
    public static void post(Object o) {
        RxBus.getDefault().post(o);
    }

    /**
     * 接收消息,并在主线程处理
     *
     * @param aClass
     * @param disposables 用于存放消息
     * @param listener
     * @param <T>
     */
    public static <T> void doOnMainThread(Class<T> aClass, CompositeDisposable disposables, OnEventListener<T> listener) {
        disposables.add(RxBus.getDefault().toFlowable(aClass).observeOn(AndroidSchedulers.mainThread()).subscribe(listener::onEvent, throwable -> listener.onError(new ErrorBean("ERROR_CODE_RXBUS", "ERROR_DESC_RXBUS"))));
    }

    public static <T> void doOnMainThread(Class<T> aClass, OnEventListener<T> listener) {
        RxBus.getDefault().toFlowable(aClass).observeOn(AndroidSchedulers.mainThread()).subscribe(listener::onEvent, throwable -> listener.onError(new ErrorBean("ERROR_CODE_RXBUS", "ErrorCode.ERROR_DESC_RXBUS")));
    }

    /**
     * 接收消息,并在子线程处理
     *
     * @param aClass
     * @param disposables
     * @param listener
     * @param <T>
     */
    public static <T> void doOnChildThread(Class<T> aClass, CompositeDisposable disposables, OnEventListener<T> listener) {
        disposables.add(RxBus.getDefault().toFlowable(aClass).subscribeOn(Schedulers.newThread()).subscribe(listener::onEvent, throwable -> listener.onError(new ErrorBean("ERROR_CODE_RXBUS", "ErrorCode.ERROR_DESC_RXBUS"))));
    }

    public static <T> void doOnChildThread(Class<T> aClass, OnEventListener<T> listener) {
        RxBus.getDefault().toFlowable(aClass).subscribeOn(Schedulers.newThread()).subscribe(listener::onEvent, throwable -> listener.onError(new ErrorBean("ERROR_CODE_RXBUS", "ErrorCode.ERROR_DESC_RXBUS")));
    }

    public interface OnEventListener<T> {
        void onEvent(T t);

        void onError(ErrorBean errorBean);
    }


      public static class ErrorBean {
        public ErrorBean(String code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        @Override
        public String toString() {
            return "ErrorBean{" +
                    "code='" + code + '\'' +
                    ", desc='" + desc + '\'' +
                    '}';
        }

        private String code;
        private String desc;

        public void setCode(String code) {
            this.code = code;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }
    }
}
