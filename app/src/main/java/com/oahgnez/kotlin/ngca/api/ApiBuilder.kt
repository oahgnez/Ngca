package com.oahgnez.kotlin.ngca.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by oahgnez on 2018/5/22.
 */
abstract class ApiBuilder {
    protected val sClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
                .build()
    }
    abstract val baseUrl: String
    open fun build(client:OkHttpClient=sClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(sClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

}