package com.chinazyjr.githubapplication.http

/**
 * Created by niudeyang on 2018/1/4.
 */

class ResultException(errCode: String, msg: String) : RuntimeException(msg) {
    var errCode = "error"

    init {
        this.errCode = errCode
    }
}
