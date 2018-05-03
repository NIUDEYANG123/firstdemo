package com.chinazyjr.githubapplication.model

import android.util.Log
import com.chinazyjr.githubapplication.api.ProductApi
import com.chinazyjr.githubapplication.api.UserApi
import com.chinazyjr.githubapplication.base.App.Companion.mLoginState
import com.chinazyjr.githubapplication.base.App.Companion.mUserName
import com.chinazyjr.githubapplication.base.BaseModel
import com.chinazyjr.githubapplication.entity.product.BorrowPlanListBean
import com.chinazyjr.githubapplication.entity.product.HomeBannerBean
import com.chinazyjr.githubapplication.entity.product.HomeListBean
import com.chinazyjr.githubapplication.entity.product.Notice
import com.chinazyjr.githubapplication.utils.AESUtils
import com.chinazyjr.haollyv2.entity.login.LoginBean
import io.reactivex.Observable

/**
 * Created by niudeyang on 2017/12/8.
 */
class ProductModel private constructor() : BaseModel() {
    private var productApi: ProductApi? = null

    init {
        productApi = retrofit!!.create(ProductApi::class.java)
    }

    private object Single {
        val instance = ProductModel()
    }

    /**
     * 单例
     */
    companion object {
        fun create(): ProductModel {
            return Single.instance
        }
    }


    /**
     * 首页列表
     */
    fun queryList(): Observable<HomeListBean> {
        var map: MutableMap<String, String> = mutableMapOf("recommendNo" to "4", "planNo" to "4")
        if (mLoginState) {
            map.put("phoneNum", mUserName)
        }
        return productApi!!.queryList(map)
    }

    /**
     * banner
     */
    fun getBanner(): Observable<HomeBannerBean> {
        return productApi!!.homebanner(mapOf("phoneNum" to mUserName))
    }

    /**
     * 公告
     */
    fun getNotice(pageNum: String, pageSize: String): Observable<Notice> {
        return productApi!!.getNotice(mapOf("pageNum" to pageNum, "pageSize" to pageSize))
    }

    fun borrowPlanList(borrowType: String, appendRate: String, peroidLengh: String, pageIndex: Int): Observable<BorrowPlanListBean> {
        return productApi!!.borrowPlanList(mapOf("phoneNum" to mUserName, "borrowType" to borrowType, "appendRate" to appendRate
                , "periodLength" to peroidLengh, "pageIndex" to pageIndex.toString()))
    }
}