package com.chinazyjr.githubapplication.base

import android.content.Intent
import android.util.Log
import com.chinazyjr.githubapplication.api.NetConstantValues
import com.chinazyjr.githubapplication.base.App.Companion.accessToken
import com.chinazyjr.githubapplication.base.App.Companion.context
import com.chinazyjr.githubapplication.base.App.Companion.mLoginState
import com.chinazyjr.githubapplication.base.App.Companion.version
import com.chinazyjr.githubapplication.entity.BaseBean
import com.chinazyjr.githubapplication.http.GsonConverterFactory1
import com.chinazyjr.haollyv2.config.Config.Companion.client
import com.chinazyjr.haollyv2.config.Config.Companion.platform
import com.chinazyjr.mylibrary.utils.LogUtils
import com.chinazyjr.mylibrary.utils.UIUtils
import com.google.gson.Gson
import okhttp3.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.HashMap
import java.util.concurrent.TimeUnit

/**
 * Created by niudeyang on 2017/12/8.
 */
open class BaseModel {
    var retrofit: Retrofit? = null
    var httpClientBuilder: OkHttpClient.Builder? = null

   //采用  val logInterceptorCombiner:
    val addBodyInterceptor: Interceptor = Interceptor { chain ->
        val orginal = chain.request()
        val requestBuilder = orginal.newBuilder()
        if (orginal.body() is FormBody) {
            val newFormBody = FormBody.Builder()
            val oldFormBody = orginal.body() as FormBody
            for (i in 0 until oldFormBody.size()) {
                newFormBody.addEncoded(oldFormBody.encodedName(i), oldFormBody.encodedValue(i))
            }
            newFormBody.add("platform", platform)
            newFormBody.add("client", client)
            newFormBody.add("version", "V$version")
            requestBuilder.method(orginal.method(), newFormBody.build())
        }
        if (mLoginState != null && accessToken != null) {
            requestBuilder.addHeader("accessToken", accessToken)
        }
        val request = requestBuilder.build()
        return@Interceptor chain.proceed(request)

    }


    val logInterceptorCombiner: Interceptor = Interceptor { chain ->
        var TAG = "LoggerInterceptor"
        val orginal = chain.request()
        val requestBuilder = orginal.newBuilder()
        if (orginal.body() is FormBody) {
            val newFormBody = FormBody.Builder()
            val oldFormBody = orginal.body() as FormBody
            for (i in 0 until oldFormBody.size()) {
                newFormBody.addEncoded(oldFormBody.encodedName(i), oldFormBody.encodedValue(i))
            }
            newFormBody.add("platform", "HLW")
            newFormBody.add("client", client)
            newFormBody.add("version", "V$version")
            requestBuilder.method(orginal.method(), newFormBody.build())
        }
        if (mLoginState != null && accessToken != null) {
            requestBuilder.addHeader("accessToken", accessToken)
        }
        val request = requestBuilder.build()
        //开始打印参数
        Log.e(TAG, "request ${request.url()}")
        val headers = request.headers()
        for (i in 0 until headers.size()) {
            val headName = headers.name(i)
            val headValue = headers.value(i)
            Log.e(TAG, "Header----------->Name:$headName------------>Value:$headValue\n")
        }
        val requestBody = request.body()

        if (requestBody is FormBody) {
            var map: MutableMap<String, String> = mutableMapOf()
            for (i in 0 until requestBody.size()) {
                map.put(requestBody.encodedName(i), requestBody.encodedValue(i))
            }
            Log.e(TAG, "params : ${Gson().toJson(map)}")
        }

        val response = chain.proceed(request)
        //----------------------------------------------------------------------------------------
        val mediaType = response.body().contentType()
        val originalBody = response.body()
        val content = originalBody?.string()
        val loginOutBean: BaseBean = Gson().fromJson(content, BaseBean::class.java)
        // Log.e(TAG, "Response body $content")
        if (mLoginState) {
            if (loginOutBean.code.equals("P-1011") || loginOutBean.code.equals("user_not_login")) {
                Thread(Runnable {
                    nextLogin(loginOutBean.msg)
                }).start()
            }
        }
        return@Interceptor response.newBuilder().body(ResponseBody.create(mediaType, content)).build()
    }

     //采用  val logInterceptorCombiner:
    val logInterceptor: Interceptor = Interceptor { chain ->
        var TAG = "LoggerInterceptor"
        val request = chain.request()
        Log.e(TAG, "request ${request.url()}")
        val headers = request.headers()
        for (i in 0 until headers.size()) {
            val headName = headers.name(i)
            val headValue = headers.value(i)
            Log.e(TAG, "Header----------->Name:$headName------------>Value:$headValue\n")
        }
        val requestBody = request.body()

        if (requestBody is FormBody) {
            var map: MutableMap<String, String> = mutableMapOf()
            for (i in 0 until requestBody.size()) {
                map.put(requestBody.encodedName(i), requestBody.encodedValue(i))
            }
            Log.e(TAG, "params : ${Gson().toJson(map)}")
        }

        val response = chain.proceed(chain.request())
        val mediaType = response.body().contentType()
        val originalBody = response.body()
        val content = originalBody?.string()
        val loginOutBean: BaseBean = Gson().fromJson(content, BaseBean::class.java)
        // Log.e(TAG, "Response body $content")
        if (mLoginState) {
            if (loginOutBean.code.equals("P-1011") || loginOutBean.code.equals("user_not_login")) {
                Thread(Runnable {
                    nextLogin(loginOutBean.msg)
                }).start()
            }
        }
        return@Interceptor response.newBuilder().body(ResponseBody.create(mediaType, content)).build()
    }

    fun nextLogin(str: String?) {
        UIUtils.showToastCommon(context, str)
        mLoginState = false
        // context.startActivity(CheckUsernameActivity.getReturnIntent(context, "logout").addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
    }

    constructor() {
        //手动创建一个OkHttpClient并设置超时时间
        httpClientBuilder = OkHttpClient.Builder()
        httpClientBuilder!!.addInterceptor(logInterceptorCombiner).readTimeout(20, TimeUnit.SECONDS).connectTimeout(20, TimeUnit.SECONDS)
        retrofit = Retrofit.Builder()
                .client(httpClientBuilder!!.build())
                .addConverterFactory(GsonConverterFactory1.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(NetConstantValues.HOST_URL)
                .build()
    }
}