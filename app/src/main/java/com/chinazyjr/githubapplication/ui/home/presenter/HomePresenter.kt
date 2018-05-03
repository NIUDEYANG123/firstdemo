package com.chinazyjr.githubapplication.ui.home.presenter

import android.app.Activity
import android.util.Log
import com.chinazyjr.githubapplication.entity.BaseBean
import com.chinazyjr.githubapplication.entity.product.HomeBannerBean
import com.chinazyjr.githubapplication.entity.product.HomeListBean
import com.chinazyjr.githubapplication.entity.product.Notice
import com.chinazyjr.githubapplication.http.NetObserver
import com.chinazyjr.githubapplication.model.ProductModel
import com.chinazyjr.githubapplication.model.UserModel
import com.chinazyjr.githubapplication.ui.home.view.HomeView
import com.chinazyjr.githubapplication.utils.toast
import com.chinazyjr.haollyv2.base.BasePresenter
import java.util.*

/**
 * Created by shanghai on 2018/4/27.
 */
class HomePresenter(mContext: Activity) : BasePresenter<HomeView>(mContext) {

    fun fetch(pageNum: String, pageSize: String) {
        invokeMerge(NetObserver<BaseBean>({ mDisposables.add(it) }, {
            if (it.code.equals("success")) {
                when (it) {
                    is Notice -> {
                        getView()!!.showNotice(it)
                    }
                    is HomeListBean -> {
                        getView()!!.showHomeList(it)
                    }
                    is HomeBannerBean -> {
                        getView()!!.showBanner(it)
                    }
                }

            } else {
                toast(it.msg!!)
            }
        }, {
            Log.e("homePresenter",it)
        }, mContext), ProductModel.create().queryList(), ProductModel.create().getNotice(pageNum, pageSize), ProductModel.create().getBanner()
        )
    }
}