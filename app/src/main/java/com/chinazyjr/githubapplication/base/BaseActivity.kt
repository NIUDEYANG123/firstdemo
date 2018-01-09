package com.chinazyjr.haollyv2.base

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.gyf.barlibrary.ImmersionBar

/**
 * Created by niudeyang on 2017/12/8.
 */
abstract class BaseActivity<out T:BasePresenter<V>,V>:AppCompatActivity(){
    protected val mPresenter: T by lazy {
       createPresenter()
    }
    protected lateinit var TAG:String
    val mContext:Context=this
    protected var mImmersionBar: ImmersionBar?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TAG=this::javaClass.name
        mPresenter!!.attach(this as V)
       // ActivityCollector.addActivity(this)
        mImmersionBar = ImmersionBar.with(this)
        mImmersionBar!!.statusBarDarkFont(false).init()
    }

    abstract fun createPresenter(): T

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
       // ActivityCollector.removeActivity(this)
        mPresenter!!.detach()
        mPresenter!!.unSubscriber()
    }
}