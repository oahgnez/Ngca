package com.oahgnez.kotlin.ngca.module.novel

/**
 * Created by oahgnez on 2018/5/22.
 */

const val BASE_URL = "http://api.zhuishushenqi.com"     //apiURL

const val STATIC_URL = "http://statics.zhuishushenqi.com"       //静态资源

const val HOST_GET_ALL_CATS = "/cats/lv2/statistics" //获取所有分类
const val HOST_GET_MIN_CATS = "/cats/lv2"    //获取小分类
const val HOST_GET_BOOK_BY_CAT = "/book/by-categories" //根据分类获取小说

const val HOST_GET_RANK_GENDERS = "/ranking/gender"  //获取排行榜标签
const val HOST_GET_RANK = "/ranking/{rankingId}"    //获取排行榜详情

//分类大标签
enum class GENDER(value: String) {
    MALE("male"),
    FEMALE("female"),
    PICTURE("picture"),
    PRESS("press")
}


//类型
enum class TYPE(value: String) {
    HOT("hot"),
    NEW("new"),
    REPULATION("repulation"),
    OVER("over"),
    MONTH("month")
}