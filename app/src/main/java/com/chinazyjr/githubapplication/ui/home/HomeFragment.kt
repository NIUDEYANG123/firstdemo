package com.chinazyjr.githubapplication.ui.home

import android.annotation.SuppressLint
import android.opengl.Visibility
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.CompoundButton
import com.ajguan.library.EasyRefreshLayout
import com.ajguan.library.LoadModel
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator
import com.bigkoo.convenientbanner.holder.Holder
import com.chinazyjr.githubapplication.R
import com.chinazyjr.githubapplication.R.id.ll_notice
import com.chinazyjr.githubapplication.R.id.lv_project
import com.chinazyjr.githubapplication.adapater.HomeProjectAdapter
import com.chinazyjr.githubapplication.api.NetConstantValues
import com.chinazyjr.githubapplication.base.BaseFragment
import com.chinazyjr.githubapplication.entity.product.HomeBannerBean
import com.chinazyjr.githubapplication.entity.product.HomeListBean
import com.chinazyjr.githubapplication.entity.product.Notice
import com.chinazyjr.githubapplication.ui.WebActivity
import com.chinazyjr.githubapplication.ui.home.presenter.HomePresenter
import com.chinazyjr.githubapplication.ui.home.view.HomeView
import com.chinazyjr.mylibrary.utils.LogUtils
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.ArrayList

/**
 * Created by shanghai on 2018/4/27.
 */
class HomeFragment : BaseFragment<HomePresenter, HomeView>(), View.OnClickListener, HomeView, EasyRefreshLayout.EasyEvent {
    private lateinit var vview: View
    private var auto_roll_strings: MutableList<String?> = mutableListOf()
    private lateinit var images: List<String?>
    private var autoRollIndex: Int = 0
    private lateinit var articleBean: HomeBannerBean.ModelBean.ArticleBean
    private lateinit var noviciateBorrowBean: HomeListBean.ModelBean.NoviciateBorrowBean
    private var borrowBeans: ArrayList<HomeListBean.ModelBean.PlanBorrowBean> = arrayListOf()
    private var list: MutableList<Notice.ModelBean.ListBean> = mutableListOf()
    private var handler: Handler = @SuppressLint("HandlerLeak")
    object : Handler() {
        override fun handleMessage(msg: Message?) {
            if (msg?.what == 199) {
                notice_auto_roll.next()
                autoRollIndex++
                notice_auto_roll.setTText(auto_roll_strings[autoRollIndex % auto_roll_strings.size])
                sendEmptyMessageDelayed(199, 3000)
            }
        }

    }

    override fun createPresenter(): HomePresenter {
        return HomePresenter(mContext)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        vview = inflater?.inflate(R.layout.fragment_home, container, false) as View
        //init()在此使用控件有nullpoint异常
        return vview
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    override fun onClick(p0: View?) {
        when (p0) {
            id_tab_iv_01 -> {
                WebActivity.getWebIntent(mContext, "关于我们", "${NetConstantValues.CONTRACT_URL}about/aboutUs.html")
            }
            id_tab_iv_02 -> {
                WebActivity.getWebIntent(mContext, "信息披露", "${NetConstantValues.CONTRACT_URL}about/disclosure.html")
            }
            id_tab_iv_03 -> {
                WebActivity.getWebIntent(mContext, "平台数据", "${NetConstantValues.CONTRACT_URL}about/disclosureD.html")
            }
            id_tab_iv_04 -> {
                WebActivity.getWebIntent(mContext, "邀请好友", "${NetConstantValues.invite}")
            }
        }
    }

    private fun init() {
        swipe_container.addEasyEvent(this)
        swipe_container.loadMoreModel = LoadModel.NONE
    }

    override fun onResume() {
        super.onResume()
        mPresenter!!.fetch("1", "3")
    }

    override fun showHomeList(it: HomeListBean) {
        borrowBeans.addAll(it.model!!.planBorrow)
        if (borrowBeans.size > 0) {
            lv_project.layoutManager = LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false)
            lv_project.adapter = HomeProjectAdapter(borrowBeans)
        }
    }

    override fun showBanner(it: HomeBannerBean) {
        if (it.model?.banner?.size != 0) {
            images = it.model!!.banner!!.map { it.imageUrl }
        }
    }

    override fun showNotice(it: Notice) {
        if (auto_roll_strings.size > 0) {
            auto_roll_strings.clear()
            handler!!.removeMessages(199)
        } else {
            list = it.model!!.list as MutableList<Notice.ModelBean.ListBean>
        }
        ll_notice.visibility = View.VISIBLE
        list.forEach { auto_roll_strings.add(it.title) }
        handler!!.sendEmptyMessage(199)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        handler?.removeCallbacksAndMessages(null)
    }

    override fun onLoadMore() {
    }

    override fun onRefreshing() {
        swipe_container.refreshComplete()
        mPresenter?.fetch("1", "3")
    }

}