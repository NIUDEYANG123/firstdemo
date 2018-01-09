package com.chinazyjr.githubapplication.http

import com.google.gson.Gson
import com.google.gson.TypeAdapter
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit

/**
 * Created by niudeyang on 2018/1/4.
 */

class GsonConverterFactory1 private constructor(private val gson: Gson?) : Converter.Factory() {

    init {
        if (gson == null) throw NullPointerException("gson == null")
    }

    override fun responseBodyConverter(type: Type?, annotations: Array<Annotation>?,
                                       retrofit: Retrofit?): Converter<ResponseBody, *> {
        val adapter = gson!!.getAdapter(TypeToken.get(type!!))
        return GsonResponseBodyConverter1(gson, adapter)
    }

    override fun requestBodyConverter(type: Type?,
                                      parameterAnnotations: Array<Annotation>?, methodAnnotations: Array<Annotation>?, retrofit: Retrofit?): Converter<*, RequestBody> {
        val adapter = gson!!.getAdapter(TypeToken.get(type!!))
        return GsonRequestBodyConverter1(gson, adapter)
    }

    companion object {

        /**
         * Create an instance using `gson` for conversion. Encoding to JSON and
         * decoding from JSON (when no charset is specified by a header) will use UTF-8.
         */
        @JvmOverloads
        fun create(gson: Gson = Gson()): GsonConverterFactory1 {
            return GsonConverterFactory1(gson)
        }
    }
}
/**
 * Create an instance using a default [Gson] instance for conversion. Encoding to JSON and
 * decoding from JSON (when no charset is specified by a header) will use UTF-8.
 */
