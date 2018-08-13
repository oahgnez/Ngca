package com.oahgnez.kotlin.ngca.module.novel.api

import com.oahgnez.kotlin.ngca.base.ApiBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by oahgnez on 2018/5/22.
 */
object NovelApiBuilder : ApiBuilder() {

    const val STATIC_URL = "http://statics.zhuishushenqi.com"       //静态资源

    override val baseUrl = "http://api.zhuishushenqi.com"
    val api: NovelApi by lazy { build().create(NovelApi::class.java) }


}

