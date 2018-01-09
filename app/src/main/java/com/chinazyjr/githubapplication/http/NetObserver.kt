package com.chinazyjr.githubapplication.http

import android.app.Activity
import android.util.Log
import com.chinazyjr.githubapplication.R
import com.chinazyjr.githubapplication.base.App
import com.chinazyjr.githubapplication.utils.netAvailable
import com.chinazyjr.haollyv2.base.IBaseView

import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import retrofit2.HttpException
import java.io.IOException


/**
 * Created by liuzipeng on 2017/2/20.可以加上进度框
 */
class NetObserver<T>(val onStart: (Disposable) -> Unit,
                     private val onResult: (T) -> Unit,
                     private val onFailure: (String) -> Unit,
                     private val context: Activity) : Observer<T> {

    private lateinit var dd: Disposable
    /**
     * //对应HTTP的状态码
     * private static final int UNAUTHORIZED = 401;
     * private static final int FORBIDDEN = 403;
     * private static final int NOT_FOUND = 404;
     * private static final int REQUEST_TIMEOUT = 408;
     * private static final int INTERNAL_SERVER_ERROR = 500;
     * private static final int BAD_GATEWAY = 502;
     * private static final int SERVICE_UNAVAILABLE = 503;
     * private static final int GATEWAY_TIMEOUT = 504;
     *
     * @param e
     */
    override fun onError(e: Throwable) {
        e.printStackTrace()
        if (e is HttpException) {
            // We had non-2XX http error
            //Toast.makeText(mContext, mContext.getString(R.string.server_internal_error), Toast.LENGTH_SHORT).show();
        } else if (e is IOException) {
            // A network or conversion error happened
            //Toast.makeText(mContext, mContext.getString(R.string.cannot_connected_server), Toast.LENGTH_SHORT).show();
        } else if (e is ApiException) {
            if (e.isTokenExpried) {
                //处理token失效对应的逻辑
            } else {
                //oast.makeText(mContext, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    override fun onComplete() {

    }

    override fun onNext(t: T) {
        onResult(t)
    }


    override fun onSubscribe(d: Disposable) {
        this.dd = d
        //如果网络不可用取消链接
        netAvailable {
            if (!it) {
                onFailure(App.instance.resources.getString(R.string.net_disable))
                d.dispose()
            } else {

            }
        }

        onStart(d)
    }
}