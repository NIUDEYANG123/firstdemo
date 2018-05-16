package com.chinazyjr.githubapplication.ui.product

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ajguan.library.EasyRefreshLayout
import com.ajguan.library.LoadModel
import com.chinazyjr.githubapplication.R
import com.chinazyjr.githubapplication.adapater.NewListAdapter
import com.chinazyjr.githubapplication.adapater.WinListAdapter
import com.chinazyjr.githubapplication.base.BaseFragment
import com.chinazyjr.githubapplication.entity.product.BorrowPlanListBean
import com.chinazyjr.githubapplication.ui.login.presenter.EmptyPresenter
import com.chinazyjr.githubapplication.ui.product.presenter.ProductListPresenter
import com.chinazyjr.githubapplication.ui.product.view.ProductListView
import com.chinazyjr.haollyv2.base.IBaseView
import kotlinx.android.synthetic.main.fragment_plan_list.*

class ProductListFragment : BaseFragment<ProductListPresenter, ProductListView>(), ProductListView {

    var vview: View? = null


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        vview = inflater?.inflate(R.layout.fragment_plan_list, container, false)
        return vview
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        //mPresenter?.getBorrowPlanList(true, "2", "1", "3", 1)
        easy_layout.autoRefresh()
    }

    private fun initView() {
        lv_new.layoutManager=LinearLayoutManager(mContext)
        lv_win_plan.layoutManager=LinearLayoutManager(mContext)
        easy_layout.loadMoreModel = LoadModel.NONE
        easy_layout.addEasyEvent(object : EasyRefreshLayout.EasyEvent{
            override fun onRefreshing() {
                mPresenter?.getBorrowPlanList(true, "2", "1", "3", 1)
            }
            override fun onLoadMore() {

            }
        })
    }

    override fun createPresenter(): ProductListPresenter? {
        return ProductListPresenter(mContext)
    }

    override fun showBorrowPlan(it: BorrowPlanListBean) {
        easy_layout.refreshComplete()
        if (it.model.noviciateBorrow.isNotEmpty()) {
            lv_new.adapter = NewListAdapter(it.model.noviciateBorrow)
        }
        //短期赢先不考虑
        //赢计划
        if (it.model.list.isNotEmpty()) {
            lv_win_plan.adapter = WinListAdapter(it.model.list)
        }
    }

    override fun showBorrowPlanMore(it: BorrowPlanListBean) {
    }
}