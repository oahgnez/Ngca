package com.oahgnez.kotlin.ngca.api

import com.oahgnez.kotlin.ngca.java.Types
import com.oahgnez.kotlin.ngca.model.data.YiYan
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by oahgnez on 2018/8/7.
 */
interface YiYanApi{
    @GET("/")
    fun getYiYan(@Query("c") @Types.YiYanType type:String=Types.YIYAN_ANIME):Observable<YiYan>
}