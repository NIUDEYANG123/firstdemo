package com.chinazyjr.haollyv2.base

import com.chinazyjr.githubapplication.http.NetObserver
import com.chinazyjr.githubapplication.utils.applySchedulers
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import java.lang.ref.WeakReference

/**
 * Created by liuzipeng on 2017/2/22.
 */
abstract class BasePresenter<T> {
    private var mViewRef: WeakReference<T>? = null
    //解除关联
    fun detach() {
        if (mViewRef != null) {
            mViewRef?.clear()
            mViewRef = null
        }
    }

    //关联
       fun attach(view: T) {
        mViewRef = WeakReference(view)

    }
    fun getView(): T? {
        return mViewRef?.get()
    }
    fun <T> invoke(observable: Observable<T>, netObserver: NetObserver<T>) {
        observable.applySchedulers().subscribe(netObserver)
    }
    val mDisposables by lazy {
        CompositeDisposable()
    }
    open fun unSubscriber() {
        if (!mDisposables.isDisposed && mDisposables.size() > 0) {
            mDisposables.isDisposed
        }
    }
}