package com.chinazyjr.githubapplication.base

import android.util.Log
import com.chinazyjr.githubapplication.api.NetConstantValues
import com.chinazyjr.githubapplication.http.GsonConverterFactory1
import com.chinazyjr.haollyv2.config.Config.Companion.client
import com.chinazyjr.haollyv2.config.Config.Companion.platform
import okhttp3.FormBody
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by niudeyang on 2017/12/8.
 */
open class BaseModel {
    var retrofit: Retrofit? = null
    var httpClientBuilder: OkHttpClient.Builder? = null
    val addQueryParameterInterceptor: Interceptor = Interceptor { chain ->
        val originalRequest = chain.request()
        val request: Request
        val method = originalRequest.method()
        val headers = originalRequest.headers()
        val modifiedUrl = originalRequest.url().newBuilder()
                // Provide your custom parameter here
                .addQueryParameter("platform", platform)
                .addQueryParameter("client", client)
                .addQueryParameter("version", "1.0.0")
                .build()
        request = originalRequest.newBuilder().url(modifiedUrl).build()
        if ("POST" == method) {
            val sb = StringBuilder()
            if (request.body() is FormBody) {
                val body = request.body() as FormBody
                if (body.size() != 0) {
                    for (i in 0 until body.size()) {
                        sb.append(body.encodedName(i) + "=" + body.encodedValue(i) + ",")
                    }
                    sb.delete(sb.length - 1, sb.length)
                    Log.e("ndy_request", originalRequest.toString() + "\n| RequestParams:{" + sb.toString() + "}")
                }
            }
        }
        return@Interceptor chain.proceed(request)
    }

    constructor() {
        //手动创建一个OkHttpClient并设置超时时间
        httpClientBuilder = OkHttpClient.Builder()
        httpClientBuilder!!.addInterceptor(addQueryParameterInterceptor).readTimeout(20, TimeUnit.SECONDS).connectTimeout(20, TimeUnit.SECONDS)
        retrofit = Retrofit.Builder()
                .client(httpClientBuilder!!.build())
                .addConverterFactory(GsonConverterFactory1.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(NetConstantValues.HOST_URL)
                .build()
    }
}