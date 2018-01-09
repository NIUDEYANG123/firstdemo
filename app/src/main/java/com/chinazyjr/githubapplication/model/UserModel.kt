package com.chinazyjr.githubapplication.model

import android.util.Log
import com.chinazyjr.githubapplication.api.UserApi
import com.chinazyjr.githubapplication.base.BaseModel
import com.chinazyjr.haollyv2.entity.login.LoginBean
import io.reactivex.Observable

/**
 * Created by niudeyang on 2017/12/8.
 */
class UserModel private constructor(): BaseModel(){
    private var userApi: UserApi?=null
    init {
        userApi = retrofit!!.create(UserApi::class.java)
    }
    private object Single{ val instance=UserModel()}
    /**
     * 单例
     */
    companion object{
        fun create():UserModel{ return Single.instance}
    }


    /**
     * 登录
     * @param phoneNum
     * @param passWord
     * @return
     */

    fun login(phoneNum: String, passWord: String): Observable<LoginBean> {
      val map:Map<String,String> = mapOf("phoneNum" to phoneNum,"passWord" to passWord)
        return userApi!!.login(map)
    }
}