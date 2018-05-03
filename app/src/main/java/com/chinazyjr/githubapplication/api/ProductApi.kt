package com.chinazyjr.githubapplication.api

import com.chinazyjr.githubapplication.api.NetConstantValues.Companion.USER_LOGIN
import com.chinazyjr.githubapplication.entity.product.BorrowPlanListBean
import com.chinazyjr.githubapplication.entity.product.HomeBannerBean
import com.chinazyjr.githubapplication.entity.product.HomeListBean
import com.chinazyjr.githubapplication.entity.product.Notice
import com.chinazyjr.haollyv2.entity.login.LoginBean
import io.reactivex.Observable
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by niudeyang on 2017/8/14.
 */

interface ProductApi {
    @FormUrlEncoded
    @POST(NetConstantValues.HOME_BANNER)
    fun homebanner(@FieldMap params: Map<String, String>): Observable<HomeBannerBean>

    @FormUrlEncoded
    @POST(NetConstantValues.NOTICE)
    fun getNotice(@FieldMap params: Map<String, String>): Observable<Notice>


    @FormUrlEncoded
    @POST(NetConstantValues.HOME_BORROW_LIST)
    fun queryList(@FieldMap params: Map<String, String>): Observable<HomeListBean>

    @FormUrlEncoded
    @POST(NetConstantValues.BORROWPLANLIST)
    fun borrowPlanList(@FieldMap params: Map<String, String>): Observable<BorrowPlanListBean>
}
