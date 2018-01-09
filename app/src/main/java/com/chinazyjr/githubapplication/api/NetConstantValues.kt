package com.chinazyjr.githubapplication.api

/**
 * Created by niudeyang on 2017/12/8.
 */
class NetConstantValues {
    companion object {
        const val HOST_URL: String = "http://api-testd.chinazyjr.net/v1/api/"
        const val image_url = HOST_URL + "common/getValidateImage"//图形验证码
        const val SMSCODE = "common/getSmsCode"//短信验证码
        const val TOKEN = "common/getToken"//获取token
        const val USERSTATUS = "common/getUserStatus"//根据手机号获取用户状态
        const val GET_BANKS = "common/getBanks"//银行卡列表
        /**
        const* 第一板块
        const*/
        const val USER_LOGIN = "user/login"//登陆
        const val USER_LOGINOUT = "user/logout"//退出登录
        const val USER_REGISTER = "user/register"//注册
        const val USER_RESETPWD = "user/forgetPassWord"//重置密码
        const val USER_CAHNGE_PASS = "user/changePassword"//修改密码
        const val USER_STATUES = "user/resetUserStatus"//刷新用户状态
        const val USER_LOGOUT = "user/logout"//退出登录
    }

}
