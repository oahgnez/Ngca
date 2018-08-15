package com.oahgnez.kotlin.ngca.api

import com.oahgnez.kotlin.ngca.java.Types
import com.oahgnez.kotlin.ngca.model.data.PixivListResult
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by oahgnez on 2018/8/14.
 */
interface PixivApi {

    companion object {
        const val s = "https://api.imjad.cn/interface/img/PixivProxy.php?url="
    }

    @GET("pixiv/v2/")
    fun search(@Types.PixivType @Query("type") type: String = Types.PIXIV_SEARCH,
               @Query("word") word: String,
               @Types.PixivOrder @Query("order") order: String = Types.PIXIV_DESC,
               @Query("page") page: Int = 1): Observable<PixivListResult>

    @GET("pixiv/v2/")
    fun rank(@Query("type") type: String = Types.PIXIV_RANK,
             @Types.PixivRankMode @Query("mode") mode: String = Types.PIXIV_RANK_WEEK,
             @Query("page") page: Int = 1,
             @Query("date") date: String = ""): Observable<PixivListResult>

}