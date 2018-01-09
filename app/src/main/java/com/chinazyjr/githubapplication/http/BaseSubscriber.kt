package com.chinazyjr.githubapplication.http

import android.content.Context

import java.io.IOException

import retrofit2.HttpException
import rx.Subscriber

/**
 * Created by niudeyang on 2018/1/4.
 */

//BaseSubscriber.java
abstract class BaseSubscriber<T>(protected var mContext: Context) : Subscriber<T>() {

    /*override fun onCompleted() {

    }

    *//**
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
     *//*
    override fun onError(e: Throwable) {
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


    override fun onNext(t: T) {

    }*/


}
