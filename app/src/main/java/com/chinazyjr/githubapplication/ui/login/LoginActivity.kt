package com.chinazyjr.haollyv2.ui.login

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.CompoundButton
import com.chinazyjr.githubapplication.R
import com.chinazyjr.githubapplication.utils.newIntent
import com.chinazyjr.githubapplication.utils.toast
import com.chinazyjr.haollyv2.base.BaseActivity
import com.chinazyjr.haollyv2.entity.login.LoginBean
import com.chinazyjr.haollyv2.ui.login.presenter.LoginPresenter
import com.chinazyjr.haollyv2.ui.login.view.LoginView
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.login_title.*

/**
 * Created by niudeyang on 2017/12/8.
 */
class LoginActivity : BaseActivity<LoginPresenter, LoginView>(), LoginView, View.OnClickListener {
    private var ck: Boolean = false
    override fun onClick(v: View?) {
        when (v) {
            btn_login -> {
                var phone = et_login_phone.trimmedString
                var pwd = et_login_pwd.trimmedString
                if (!ck) {
                    toast(getString(R.string.agree_platform));return
                }
                if (TextUtils.isEmpty(phone)) {
                    toast(getString(R.string.tip_mobile));return
                }
                if (TextUtils.isEmpty(pwd)) {
                    toast(getString(R.string.tip_pass));return
                }
                mPresenter!!.login2(phone, pwd)
            }
            iv_close -> finish()
            tv_login_contract -> {
                toast("查看合同")
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initListener()
    }

    private fun initListener() {
        et_login_phone.setPattern(intArrayOf(3, 4, 4))
        btn_login.setOnClickListener(this)
        iv_close.setOnClickListener(this)
        tv_register.setOnClickListener(this)
        tv_login_contract.setOnClickListener(this)
        cb_login_proctor.setOnCheckedChangeListener { _, p1 -> ck = p1 }
    }

    override fun login(it: LoginBean) {
        Log.e("loginactivity", it.msg)
    }

    override fun createPresenter(): LoginPresenter = LoginPresenter(this)

}