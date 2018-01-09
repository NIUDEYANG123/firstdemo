package com.chinazyjr.githubapplication.http


/**
 * Created by niudeyang on 2018/1/4.
 */

class ApiException(
        //ApiException.java

        private val mErrorCode: Int, errorMessage: String) : RuntimeException(errorMessage) {

    /**
     * 判断是否是token失效
     *
     * @return 失效返回true, 否则返回false;
     */
    val isTokenExpried: Boolean
        get() = mErrorCode == Constants.TOKEN_EXPRIED
}

