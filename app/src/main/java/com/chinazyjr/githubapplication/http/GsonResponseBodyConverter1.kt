package com.chinazyjr.githubapplication.http

import android.util.Log

import com.google.gson.Gson
import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader

import java.io.ByteArrayInputStream
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.io.Reader
import java.nio.charset.Charset

import okhttp3.MediaType
import okhttp3.ResponseBody
import retrofit2.Converter

import java.nio.charset.StandardCharsets.UTF_8

/**
 * Created by niudeyang on 2018/1/4.
 */


class GsonResponseBodyConverter1<T> internal constructor(private val gson: Gson, private val adapter: TypeAdapter<T>) : Converter<ResponseBody, T> {

    /**
     * JsonReader jsonReader = gson.newJsonReader(value.charStream());
     *
     *
     * try {
     * return adapter.read(jsonReader);
     * } finally {
     * value.close();
     * }
     */
    @Throws(IOException::class)
    override fun convert(value: ResponseBody): T {
        val response = value.string()
        Log.e("ndy_BodyConverter1", "response>>" + response)
        val resultResponse = gson.fromJson(response, ResultResponse::class.java)
        if (resultResponse.code != "success") {
            //ErrResponse 将msg解析为异常消息文本
            val errResponse = gson.fromJson(response, ResultResponse::class.java)
            throw ResultException(resultResponse.code!!, errResponse.msg!!)
        }
        val contentType = value.contentType()
        var charset: Charset? = null
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            charset = if (contentType != null) contentType.charset(UTF_8) else UTF_8
        }
        val inputStream = ByteArrayInputStream(response.toByteArray())
        val reader = InputStreamReader(inputStream, charset!!)
        val jsonReader = gson.newJsonReader(reader)

        try {
            return adapter.read(jsonReader)
        } finally {
            value.close()
        }
    }
}