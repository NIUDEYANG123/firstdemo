package com.chinazyjr.githubapplication.base

import android.app.Application
import android.content.Context
import com.chinazyjr.githubapplication.utils.NotNullSingleValueVar
import com.chinazyjr.githubapplication.utils.Utils
import com.taobao.sophix.PatchStatus
import com.taobao.sophix.SophixManager
import com.taobao.sophix.listener.PatchLoadStatusListener

/**
 * Created by niudeyang on 2018/1/8.
 */
class App : Application() {
    companion object {
        var instance: App by NotNullSingleValueVar.DelegatesExt.notNullSingleValue()
        lateinit var context: Context
        var userId = -1
        var mUserName = ""
        var phone = ""

        var accessToken = ""
        var refreshToken = ""
        var version: String=""//版本号
        var juid = ""//平台客户号
        var juidMd5 = ""//加密后的平台客户号
        var userCustId = ""//第三方客户号
        var step: Int = 0//开户状态
        var signstatus: Boolean = false//签约状态
        var noUpdate: Boolean = false//更新取消按钮
        var noIsApp: Boolean = false//更新是否是app再次进入
        var sms_seq_: String? = null
        var riskCheck: Int = 0//风险测评是否 1 0
        var exist: Boolean = false//是否新用户 true老用户  false新用户
        var mLoginState:Boolean=false
    }
    override fun onCreate() {
        super.onCreate()
       // LogUtils.isDebug=true
        instance = this
        context=applicationContext
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
    }

}