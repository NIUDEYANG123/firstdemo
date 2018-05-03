package com.chinazyjr.haollyv2.base

import android.app.Activity
import android.content.Context
import android.nfc.Tag
import com.chinazyjr.githubapplication.base.BaseModel
import com.chinazyjr.githubapplication.entity.BaseBean
import com.chinazyjr.githubapplication.http.NetObserver
import com.chinazyjr.githubapplication.utils.applySchedulers
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import org.reactivestreams.Subscriber
import java.lang.ref.WeakReference

/**
 * Created by liuzipeng on 2017/2/22.
 */
abstract class BasePresenter<T>(val mContext: Activity) {
    private var mViewRef: WeakReference<T>? = null
    protected val tag: String=javaClass.name
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

    fun invokeMerge(netObserver: NetObserver<BaseBean>,vararg observables: Observable<out BaseBean>) {
        var observable: Observable<out BaseBean> = observables[0]
        when (observables.size) {
            1 -> {
                observable = observables[0]
            }
            2 -> {
                observable = Observable.merge(observables[0], observables[1])
            }
            3 -> {
                observable = Observable.merge(observables[0], observables[1], observables[2])
            }
        }

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
