package com.chinazyjr.githubapplication.ui.home.view

import com.chinazyjr.githubapplication.entity.product.HomeBannerBean
import com.chinazyjr.githubapplication.entity.product.HomeListBean
import com.chinazyjr.githubapplication.entity.product.Notice

/**
 * Created by shanghai on 2018/4/27.
 */
interface HomeView {
    fun showNotice(it: Notice)
    fun showHomeList(it: HomeListBean)
    fun showBanner(it: HomeBannerBean)
}