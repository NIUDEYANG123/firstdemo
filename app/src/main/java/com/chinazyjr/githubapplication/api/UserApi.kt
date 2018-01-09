package com.chinazyjr.githubapplication.api

import com.chinazyjr.githubapplication.api.NetConstantValues.Companion.USER_LOGIN
import com.chinazyjr.haollyv2.entity.login.LoginBean
import io.reactivex.Observable
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by niudeyang on 2017/8/14.
 */

interface UserApi {
    @FormUrlEncoded
    @POST(USER_LOGIN)
    fun login(@FieldMap params: Map<String, String>): Observable<LoginBean>

}
