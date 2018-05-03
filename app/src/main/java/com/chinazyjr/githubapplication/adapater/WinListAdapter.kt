package com.chinazyjr.githubapplication.adapater

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.chinazyjr.githubapplication.R
import com.chinazyjr.githubapplication.custom.CustomizedProgressBar
import com.chinazyjr.githubapplication.entity.product.BorrowPlanListBean
import com.chinazyjr.githubapplication.entity.product.HomeListBean

class WinListAdapter(var list: List<BorrowPlanListBean.Model.X>) : BaseQuickAdapter<BorrowPlanListBean.Model.X, BaseViewHolder>(R.layout.item_product_list, list) {
    override fun convert(helper: BaseViewHolder?, item: BorrowPlanListBean.Model.X) {
        if(helper?.layoutPosition==0){
            helper?.setVisible(R.id.ll_title,true)
            helper?.setText(R.id.tv_group,"赢计划")
        }else{
            helper?.setVisible(R.id.ll_title,false)
        }
        helper?.setText(R.id.tv_borrow_name, item.borrowName)
        val pr=helper?.getView<CustomizedProgressBar>(R.id.progress) as CustomizedProgressBar
        pr.maxCount=100f
        pr.currentCount=100f
    }
}