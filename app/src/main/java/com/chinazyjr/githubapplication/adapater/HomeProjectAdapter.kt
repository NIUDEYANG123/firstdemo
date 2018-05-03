package com.chinazyjr.githubapplication.adapater

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.chinazyjr.githubapplication.R
import com.chinazyjr.githubapplication.entity.product.HomeListBean

class HomeProjectAdapter(var list:List<HomeListBean.ModelBean.PlanBorrowBean>) : BaseQuickAdapter<HomeListBean.ModelBean.PlanBorrowBean,BaseViewHolder>(R.layout.item_home_product_list,list){
    override fun convert(helper: BaseViewHolder?, item: HomeListBean.ModelBean.PlanBorrowBean?) {
        helper?.setText(R.id.tv_name,item?.borrowName)
    }
}