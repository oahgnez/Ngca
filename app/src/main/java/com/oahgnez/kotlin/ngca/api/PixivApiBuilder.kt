package com.oahgnez.kotlin.ngca.api

/**
 * Created by oahgnez on 2018/8/14.
 */
object PixivApiBuilder : ApiBuilder() {
    override val baseUrl: String = "https://api.imjad.cn/"
    val api :PixivApi by lazy { build().create(PixivApi::class.java) }
}


