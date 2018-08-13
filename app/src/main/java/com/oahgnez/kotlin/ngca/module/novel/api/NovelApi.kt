package com.oahgnez.kotlin.ngca.module.novel.api

import com.oahgnez.kotlin.ngca.base.BaseApi
import com.oahgnez.kotlin.ngca.java.Types
import com.oahgnez.kotlin.ngca.module.novel.data.model.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by oahgnez on 2018/5/22.
 */
interface NovelApi:BaseApi {
    companion object {
        const val HOST_GET_MAJORS = "/cats/lv2/statistics" //获取所有分类
        const val HOST_GET_MINORS = "/cats/lv2"    //获取小分类
        const val HOST_GET_BOOK_BY_CAT = "/book/by-categories" //根据分类获取小说
        const val HOST_GET_RANK_GENDERS = "/ranking/gender"  //获取排行榜标签
        const val HOST_GET_RANK = "/ranking/{rankingId}"    //获取排行榜详情
        const val HOST_GET_BOOK_INFO = "/book/{bookId}"
        const val HOST_GET_BOOK_SOURCE ="/book"
    }

    @GET(HOST_GET_MAJORS)
    fun getMajors(): Observable<MajorResults>

    @GET(HOST_GET_MINORS)
    fun getMinors(): Observable<MinorResults>


    /**
     * gender: 男生:mael 女生:female 出版:presses
    type: 热门:hot 新书:new 好评:repulation 完结: over 包月: month
    major: 大类别 从接口1获取
    minor: 小类别 从接口4获取 (非必填)
    start: 分页开始页
    limit: 分页条数
     **/
    @GET(HOST_GET_BOOK_BY_CAT)
    fun getBooksByCat(@Types.GenderType @Query("gender") gender: String,
                      @Types.CatsType @Query("type") type: String,
                      @Query("major") major: String,
                      @Query("minor") minor: String,
                      @Query("start") start: Int,
                      @Query("limit") limit: Int): Observable<BookResults>

    /**
     * 获取排行榜标签*/
    @GET(HOST_GET_RANK_GENDERS)
    fun getRankGenders(): Observable<RankGenderResults>

    /**
     * 获取特定排行榜信息*/
    @GET(HOST_GET_RANK)
    fun getBooksByRank(@Path("rankingId") rankingId: String): Observable<RankResultModel>

    /* 获取书籍信息*/
    @GET(HOST_GET_BOOK_INFO)
    fun getBookInfo(@Path("bookId") bookId: String): Observable<BookInfo>

    /*获取书籍源*/

}