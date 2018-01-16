package com.chinazyjr.mylibrary.retrofit;

import io.reactivex.disposables.Disposable;

public interface SubscriberOnNextListener<T> {
    void onNext(T t);
    void onError(Throwable e);
    void onSubscribe(Disposable d);
}