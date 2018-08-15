package com.oahgnez.kotlin.ngca.api

/**
 * Created by oahgnez on 2018/5/22.
 */
object NovelApiBuilder : ApiBuilder() {

    const val STATIC_URL = "http://statics.zhuishushenqi.com"       //静态资源

    override val baseUrl = "http://api.zhuishushenqi.com"
    val api: NovelApi by lazy { build().create(NovelApi::class.java) }


}

