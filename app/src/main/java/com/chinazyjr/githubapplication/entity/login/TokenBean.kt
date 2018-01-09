package com.chinazyjr.haollyv2.entity.login

/**
 * Created by liliang on 2017/9/11.
 */

class TokenBean{

    /**
     * code : success
     * msg : 成功
     * model : {"token":"6630aec4cb144301a8184e0b215a4f83"}
     */

    var code: String? = null
    var msg: String? = null
    var model: ModelBean? = null

    class ModelBean {
        /**
         * token : 6630aec4cb144301a8184e0b215a4f83
         */
        var token: String? = null


    }
}
