package com.chinazyjr.githubapplication.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chinazyjr.githubapplication.R
import com.chinazyjr.githubapplication.base.BaseFragment
import com.chinazyjr.githubapplication.ui.login.presenter.EmptyPresenter
import com.chinazyjr.haollyv2.base.IBaseView

/**
 * Created by shanghai on 2018/4/27.
 */
class MyFragment :BaseFragment<EmptyPresenter,IBaseView>(){
    private lateinit var vview: View
    override fun createPresenter(): EmptyPresenter? {
        return null
    }
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        vview= inflater?.inflate(R.layout.fragment_home,container,false) as View
        return vview
    }
}