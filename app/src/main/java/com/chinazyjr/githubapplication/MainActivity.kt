package com.chinazyjr.githubapplication

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentStatePagerAdapter
import android.view.KeyEvent
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.chinazyjr.githubapplication.R.id.id_tab_iv_03
import com.chinazyjr.githubapplication.R.id.id_tab_tv_03
import com.chinazyjr.githubapplication.ui.home.HomeFragment
import com.chinazyjr.githubapplication.ui.home.MyFragment
import com.chinazyjr.githubapplication.ui.home.ProductFragment
import com.chinazyjr.githubapplication.ui.login.presenter.EmptyPresenter
import com.chinazyjr.githubapplication.utils.clickBack
import com.chinazyjr.haollyv2.base.BaseActivity
import com.chinazyjr.haollyv2.base.BasePresenter
import com.chinazyjr.haollyv2.base.IBaseView
import com.chinazyjr.haollyv2.ui.login.LoginActivity
import com.gyf.barlibrary.ImmersionBar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.public_bottom_main.*
import java.util.jar.Manifest

class MainActivity : BaseActivity<EmptyPresenter, IBaseView>(), View.OnClickListener {
    //private var homeFragment: HomeFragment? = null
    //private var productFragment: ProductFragment? = null
    //    private FindFragment findFragment;
    //private var myFragment: MyFragment? = null
    private var fragments: MutableList<Fragment>? = mutableListOf()
    var currentPage: Int = 0
    companion object {
        fun getMainIntent(context: Context, page: Int): Intent {
            val intent = Intent(context, MainActivity::class.java)
            intent.putExtra("current", page)
            return intent
        }
    }

    override fun createPresenter(): EmptyPresenter {
        return EmptyPresenter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        if (Build.VERSION.SDK_INT >= 23) {
            var array: Array<String> = arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.READ_LOGS,
                    android.Manifest.permission.READ_PHONE_STATE, android.Manifest.permission.READ_EXTERNAL_STORAGE)
            requestPermissions(array, 123)
        }
        fragments?.add(HomeFragment())
        fragments?.add(ProductFragment())
        fragments?.add(MyFragment())


        id_main_viewPager.adapter = object : FragmentStatePagerAdapter(supportFragmentManager) {
            override fun getCount(): Int {
                return fragments!!.size
            }

            override fun getItem(position: Int): Fragment {
                return fragments!![position]
            }
        }

        id_tab_ll_01.setOnClickListener(this)
        id_tab_ll_02.setOnClickListener(this)
        id_tab_ll_04.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0) {
            id_tab_ll_01 -> {
                currentPage = 0
                setTabSelection(0)
            }
            id_tab_ll_02 -> {
                currentPage = 1
                setTabSelection(1)
            }
            id_tab_ll_04 -> {
                currentPage = 3
                setTabSelection(3)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        setTabSelection(currentPage)

    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        setIntent(intent)
        val cp = getIntent().getIntExtra("current", -1)
        if (cp != -1) {
            currentPage = cp
        }

        initIntent(intent)
    }

    private fun initIntent(intent: Intent?) {
        if (intent!!.getBooleanExtra("exitLogin", false)) {
            startActivity(Intent(mContext, LoginActivity::class.java))
        }
    }

    private fun setTabSelection(currentPage: Int) {
        resetView()
        when (currentPage) {
            0 -> {
                id_tab_tv_01.setTextColor(resources.getColor(R.color.tv_navigate_checked))
                id_tab_iv_01.setImageResource(R.drawable.ic_home_checked)
                switchPager(currentPage)
            }
            1 -> {
                id_tab_tv_02.setTextColor(resources.getColor(R.color.tv_navigate_checked))
                id_tab_iv_02.setImageResource(R.drawable.ic_product_checked)
                switchPager(currentPage)
            }
            3 -> {
                id_tab_tv_04.setTextColor(resources.getColor(R.color.tv_navigate_checked))
                id_tab_iv_04.setImageResource(R.drawable.ic_my_checked)
                switchPager(currentPage)
            }
        }
    }

    private fun switchPager(currentPage: Int) = id_main_viewPager.setCurrentItem(currentPage, false)

    private fun resetView() {
        id_tab_iv_01.setImageResource(R.drawable.ic_home)
        id_tab_iv_02.setImageResource(R.drawable.ic_product)
        id_tab_iv_04.setImageResource(R.drawable.ic_my)
        id_tab_tv_01.setTextColor(resources.getColor(R.color.tv_navigate))
        id_tab_tv_02.setTextColor(resources.getColor(R.color.tv_navigate))
        id_tab_tv_04.setTextColor(resources.getColor(R.color.tv_navigate))
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        return clickBack(keyCode, event)
    }
}
