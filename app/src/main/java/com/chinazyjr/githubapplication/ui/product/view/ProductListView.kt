package com.chinazyjr.githubapplication.ui.product.view

import com.chinazyjr.githubapplication.entity.product.BorrowPlanListBean

interface ProductListView {
    fun showBorrowPlan(it: BorrowPlanListBean)
    fun showBorrowPlanMore(it: BorrowPlanListBean)

}