package com.oahgnez.kotlin.ngca.module.novel.api

import com.oahgnez.kotlin.ngca.base.ApiBuilder
import com.oahgnez.kotlin.ngca.module.novel.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by oahgnez on 2018/5/22.
 */
class NovelApiBuilder : ApiBuilder() {
    companion object {
        private val sClient by lazy {
            OkHttpClient.Builder()
                    .build()
        }

        fun builder(): NovelApi =
                Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .client(sClient)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .build()
                        .create(NovelApi::class.java)

    }


}

