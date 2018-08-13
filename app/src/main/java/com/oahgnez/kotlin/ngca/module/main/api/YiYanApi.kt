package com.oahgnez.kotlin.ngca.module.main.api

import com.oahgnez.kotlin.ngca.java.Types
import com.oahgnez.kotlin.ngca.module.main.model.data.YiYan
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by oahgnez on 2018/8/7.
 */
interface YiYanApi{
    @GET("/")
    fun getYiYan(@Query("c") @Types.YiYanType type:String):Observable<YiYan>
}