package com.chinazyjr.mylibrary.retrofit;

public interface SubscriberOnNextListener<T> {
    void onNext(T t);
    void onError(Throwable e);

}