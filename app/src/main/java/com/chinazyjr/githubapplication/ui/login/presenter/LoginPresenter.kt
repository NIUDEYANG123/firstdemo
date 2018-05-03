package com.chinazyjr.haollyv2.ui.login.presenter

import android.app.Activity
import android.content.Context
import android.util.Log
import com.chinazyjr.githubapplication.GodClass
import com.chinazyjr.githubapplication.http.NetObserver
import com.chinazyjr.githubapplication.model.UserModel
import com.chinazyjr.haollyv2.base.BasePresenter
import com.chinazyjr.haollyv2.ui.login.view.LoginView
import com.chinazyjr.githubapplication.utils.applySchedulers
import com.chinazyjr.haollyv2.entity.login.LoginBean
import com.chinazyjr.mylibrary.utils.LogUtils
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.ObservableSource
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Function
import io.reactivex.functions.Predicate
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Subscriber

/**
 * Created by niudeyang on 2017/12/8.
 */
class LoginPresenter(val view: Activity, mContext: Activity) : BasePresenter<LoginView>(mContext) {
    private val userModel: UserModel by lazy {
        UserModel.create()
    }

    /**
     * 统一封装
     */
    fun login(phone: String, pass: String) {
        invoke(userModel.login(phone, pass), NetObserver<LoginBean>({ mDisposables.add(it) }, { Log.e(tag, "bbbb");getView()!!.login(it) }, { Log.e(tag, it) }, mContext))
        //userModel.login(phone,pass).compose(RxHelper.singleModeThread()).subscribe(NetObserver({mDisposables.add(it)},{LogUtils.e(tag,"bbbb")},{LogUtils.e(tag,it)},view))
    }

    /**
     * 常规实现1
     */
    fun login2(phone: String, pass: String) {
        val disposeble = userModel.login(phone, pass).applySchedulers().subscribe({ it ->
            getView()!!.login(it)
        }
                , { error -> Log.e(tag, error.message) }
                , { })
        mDisposables.add(disposeble)
    }



    /**
     * 常规实现2
     */
    fun login3(phone:String,pass:String){
        val subscribe = userModel.login(phone, pass).applySchedulers().subscribe({ it ->
            getView()!!.login(it)
        })
        mDisposables.add(subscribe)
    }

    fun testRxjava(phone:String,pass:String){
        userModel.login(phone,pass).subscribeOn(Schedulers.io())
                .filter(Predicate<LoginBean>{
                    return@Predicate it.code.equals("success")
    }).doOnNext({}).subscribe()
}}