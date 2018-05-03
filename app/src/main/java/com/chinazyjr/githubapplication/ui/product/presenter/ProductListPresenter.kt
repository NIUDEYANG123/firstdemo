package com.chinazyjr.githubapplication.ui.product.presenter

import android.app.Activity
import android.util.Log
import com.chinazyjr.githubapplication.http.NetObserver
import com.chinazyjr.githubapplication.model.ProductModel
import com.chinazyjr.githubapplication.ui.product.view.ProductListView
import com.chinazyjr.haollyv2.base.BasePresenter

class ProductListPresenter(var activity: Activity) : BasePresenter<ProductListView>(activity) {

    public fun getBorrowPlanList(refresh: Boolean, borrowType: String, appendRate: String, peroidLengh: String, pageIndex: Int) {
        invoke(ProductModel.create().borrowPlanList(borrowType, appendRate, peroidLengh, pageIndex),
                NetObserver({ mDisposables.add(it) }, {
                    if (refresh) {
                        getView()?.showBorrowPlan(it)
                    } else {
                        getView()?.showBorrowPlanMore(it)
                    }
                }, { Log.e(tag, it) }, activity)
        )
    }
}