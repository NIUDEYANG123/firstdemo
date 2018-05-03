package com.chinazyjr.githubapplication.base

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.chinazyjr.haollyv2.base.BasePresenter

/**
 * Created by shanghai on 2018/4/27.
 */
abstract class BaseFragment<T : BasePresenter<V>, V> : Fragment() {
    protected val mPresenter: T? by lazy {
        createPresenter()
    }
    protected lateinit var mContext: Activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = activity
        mPresenter?.attach(this as V)

    }
    abstract fun createPresenter(): T?
    override fun onDestroy() {
        super.onDestroy()
        mPresenter?.detach()
    }
}