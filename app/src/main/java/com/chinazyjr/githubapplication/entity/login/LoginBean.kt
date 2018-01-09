package com.chinazyjr.haollyv2.entity.login

/**
 * Created by niudeyang on 2017/8/15.
 */

class LoginBean {

    /**
     * data : {"user_code_":"1708141153560319","user_id_":1241,"appmsg":"登录成功","success":true,"juid":"1708141153560319","appcode":"1","mobile_":"18305517576"}
     * appmsg : 登录成功
     * appcode : 1
     */

    var model: ModelBean? = null
    var msg: String? = null
    var code: String? = null


    class ModelBean {
        /**
         * openAccountStatus : 1
         * lastLoginTime : 1505182741211
         * mobile : 13609155145
         * id : 49
         * userCode : f2bbfb28
         * status : 1
         * lastLoginIp : 3232238398
         */

        var openAccountStatus: String? = null
        var lastLoginTime: String? = null
        var mobile: String? = null
        var id: Int = 0
        var userCode: String? = null
        var status: String? = null
        var lastLoginIp: String? = null


    }
}
