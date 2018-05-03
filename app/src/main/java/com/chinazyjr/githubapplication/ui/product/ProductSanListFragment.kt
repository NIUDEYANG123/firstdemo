package com.chinazyjr.githubapplication.ui.product

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ajguan.library.EasyRefreshLayout
import com.chinazyjr.githubapplication.R
import com.chinazyjr.githubapplication.adapater.SanListAdapter
import com.chinazyjr.githubapplication.base.BaseFragment
import com.chinazyjr.githubapplication.entity.product.BorrowPlanListBean
import com.chinazyjr.githubapplication.ui.product.presenter.ProductListPresenter
import com.chinazyjr.githubapplication.ui.product.view.ProductListView
import kotlinx.android.synthetic.main.fragment_asset.*

class ProductSanListFragment : BaseFragment<ProductListPresenter, ProductListView>(),ProductListView{
    var vview: View? = null
    var pageIndex: Int = 1
     var list: MutableList<BorrowPlanListBean.Model.X> = mutableListOf()
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        vview = inflater?.inflate(R.layout.fragment_asset, container, false)
        return vview
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        easy_layout.autoRefresh(2000)
    }

    private fun init() {
        recycle_asset.layoutManager=LinearLayoutManager(mContext)
        easy_layout.addEasyEvent(object : EasyRefreshLayout.EasyEvent{
           override fun onRefreshing() {
               pageIndex=1
               mPresenter?.getBorrowPlanList(true, "1", "1", "3", 1)
           }

           override fun onLoadMore() {
               pageIndex++
               mPresenter?.getBorrowPlanList(false, "1", "1", "3", pageIndex)
           }
       })
    }

    override fun createPresenter(): ProductListPresenter? {
        return ProductListPresenter(mContext)
    }
    lateinit var adapterr:SanListAdapter
    override fun showBorrowPlan(it: BorrowPlanListBean) {
        easy_layout.refreshComplete()
        list.clear()
        list.addAll(it.model.list)
        adapterr=SanListAdapter(list)
        recycle_asset.adapter=adapterr
    }

    override fun showBorrowPlanMore(it: BorrowPlanListBean) {
        easy_layout.loadMoreComplete()
        list.addAll(it.model.list)
        adapterr.notifyDataSetChanged()

    }
}