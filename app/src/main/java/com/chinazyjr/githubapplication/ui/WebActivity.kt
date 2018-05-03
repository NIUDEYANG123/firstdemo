package com.chinazyjr.githubapplication.ui

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.http.SslError
import android.opengl.Visibility
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.text.TextUtils
import android.view.KeyEvent
import android.view.View
import android.webkit.*
import com.chinazyjr.githubapplication.R
import com.chinazyjr.githubapplication.api.NetConstantValues
import com.chinazyjr.githubapplication.base.App.Companion.accessToken
import com.chinazyjr.githubapplication.base.App.Companion.juid
import com.chinazyjr.githubapplication.base.App.Companion.mUserName
import com.chinazyjr.githubapplication.base.App.Companion.signstatus
import com.chinazyjr.githubapplication.ui.login.presenter.EmptyPresenter
import com.chinazyjr.githubapplication.utils.clickBack
import com.chinazyjr.githubapplication.utils.toast
import com.chinazyjr.haollyv2.base.BaseActivity
import com.chinazyjr.haollyv2.base.IBaseView
import com.chinazyjr.haollyv2.config.Config.Companion.returl
import com.chinazyjr.mylibrary.utils.UIUtils
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_web.*
import kotlinx.android.synthetic.main.public_title_back_blue.*
import org.w3c.dom.Text

/**
 * Created by shanghai on 2018/4/27.
 */
class WebActivity : BaseActivity<EmptyPresenter, IBaseView>() {
    override fun createPresenter(): EmptyPresenter {
        return EmptyPresenter(this)
    }

    private lateinit var title: String
    private lateinit var html: String
    private lateinit var content: String

    companion object {
        fun getWebIntent(context: Context, title: String, html: String): Intent {
            var intent = Intent(context, WebActivity::class.java)
            intent.putExtra("title", title)
            intent.putExtra("html", html)
            return intent
        }

        fun getWebIntentContent(context: Context, title: String, html: String): Intent {
            var intent = Intent(context, WebActivity::class.java)
            intent.putExtra("title", title)
            intent.putExtra("content", html)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
        initView()
    }

    override fun onDestroy() {
        super.onDestroy()
        web_sh.clearCache(true)
    }

    private fun initView() {
        tv_menu.setOnClickListener { web_sh.loadUrl("javascript:Submith5Date()") }
        iv_finish.setOnClickListener { v ->
            if (web_sh.canGoBack()) {
                web_sh.settings.cacheMode = WebSettings.LOAD_NO_CACHE
                web_sh.goBack()
            } else {
                finish()
            }
        }
        title = intent.getStringExtra("title")
        html = intent.getStringExtra("html")
        content = intent.getStringExtra("content")
        tv_title.text = title
        if (title.equals("邀请好友")) {
            tv_menu.visibility = View.VISIBLE
        }
        if (TextUtils.isEmpty(html)) {
            initWebView(content, false)
        } else {
            initWebView(html, true)
        }

    }

    private fun initWebView(html: String?, b: Boolean) {
        // 在安卓5.0之后，默认不允许加载http与https混合内容，需要设置webview允许其加载混合网络协议内容
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            web_sh.settings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        }

        web_sh.isDrawingCacheEnabled = true
        web_sh.scrollBarStyle = WebView.SCROLLBARS_OUTSIDE_OVERLAY
        web_sh.requestFocus()
        web_sh.settings.savePassword = false
        web_sh.settings.defaultTextEncodingName = "utf-8"
        web_sh.settings.layoutAlgorithm = WebSettings.LayoutAlgorithm.SINGLE_COLUMN
        web_sh.settings.loadWithOverviewMode = true
        web_sh.settings.useWideViewPort = true
        web_sh.settings.setSupportZoom(true)

        web_sh.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                if (newProgress == 100) {
                    web_p.visibility = View.GONE
                } else {
                    web_p.visibility = View.VISIBLE
                }
            }
        }
        web_sh.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    view?.loadUrl(request?.url.toString())
                } else {
                    view?.loadUrl(request.toString())
                }
                return true
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                if (url!!.startsWith(returl)) {
                    //认为签约成功
                    signstatus = true
                    finish()
                } else if (url.contains(NetConstantValues.watch_old)) {
                    finish()
                }
            }

            override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler?, error: SslError?) {
                handler!!.proceed()
            }
        }

        web_sh.addJavascriptInterface(JavaScriptInterface(), "Android")
    }


    inner class JavaScriptInterface {

        @JavascriptInterface
        fun invite(json: String) {
            toast("邀请好友")
        }

        @JavascriptInterface
        fun inviteCallBack(): String {
            var map = mapOf<String, String>("mobile" to mUserName, "userCode" to juid, "token" to accessToken)
            return Gson().toJson(map)
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && web_sh.canGoBack()) {
            // 返回上一页面
            web_sh.getSettings().cacheMode = WebSettings.LOAD_NO_CACHE
            web_sh.goBack()
            return true
        } else {
            finish()
        }
        return super.onKeyDown(keyCode, event)
    }
}