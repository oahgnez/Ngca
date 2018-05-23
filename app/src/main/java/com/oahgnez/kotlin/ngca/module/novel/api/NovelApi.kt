package com.oahgnez.kotlin.ngca.module.novel.api

import com.oahgnez.kotlin.ngca.module.novel.*
import com.oahgnez.kotlin.ngca.module.novel.model.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by oahgnez on 2018/5/22.
 */
interface NovelApi {
    @GET(HOST_GET_ALL_CATS)
    fun getAllCats(): Observable<CatsModel>

    @GET(HOST_GET_MIN_CATS)
    fun getMinTypes(): Observable<MinCatsModel>


    /**
     * gender: 男生:mael 女生:female 出版:press
    type: 热门:hot 新书:new 好评:repulation 完结: over 包月: month
    major: 大类别 从接口1获取
    minor: 小类别 从接口4获取 (非必填)
    start: 分页开始页
    limit: 分页条数
     **/
    @GET(HOST_GET_BOOK_BY_CAT)
    fun getBooksByCat(@Query("gender") gender: String,
                      @Query("type") type: String,
                      @Query("major") major: String,
                      @Query("minor") minor: String,
                      @Query("start") start: Int,
                      @Query("limit") limit: Int): Observable<BooksModel>

/**
 * 获取排行榜标签*/

    @GET(HOST_GET_RANK_GENDERS)
    fun getRankGenders():Observable<RankGendersModel>

    /**
     * 获取特定排行榜信息*/
    @GET(HOST_GET_RANK)
    fun getRank(@Path("rankingId") rankingId:String):Observable<RankModel>
}