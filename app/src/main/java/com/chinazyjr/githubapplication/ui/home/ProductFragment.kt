package com.chinazyjr.githubapplication.ui.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chinazyjr.githubapplication.R
import com.chinazyjr.githubapplication.R.id.vp_product
import com.chinazyjr.githubapplication.adapater.TabAdapter
import com.chinazyjr.githubapplication.base.BaseFragment
import com.chinazyjr.githubapplication.ui.login.presenter.EmptyPresenter
import com.chinazyjr.githubapplication.ui.product.ProductListFragment
import com.chinazyjr.githubapplication.ui.product.ProductSanListFragment
import com.chinazyjr.haollyv2.base.IBaseView
import kotlinx.android.synthetic.main.fragment_product_main.*

/**
 * Created by shanghai on 2018/4/27.
 */
class ProductFragment : BaseFragment<EmptyPresenter, IBaseView>() {
    private var fragments: ArrayList<Fragment> = arrayListOf()
    private var titles: Array<String> = arrayOf("赢计划", "散标")
    private lateinit var vview: View
    override fun createPresenter(): EmptyPresenter? {
        return null
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        vview = inflater?.inflate(R.layout.fragment_product_main, container, false) as View
        return vview
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }
    private fun initView() {
        fragments.clear()
        fragments.add(ProductListFragment())
        fragments.add(ProductSanListFragment())
        vp_product.adapter = TabAdapter(childFragmentManager, fragments, titles.toList())
        tab_product.setupWithViewPager(vp_product)
    }
}