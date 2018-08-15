package com.oahgnez.kotlin.ngca.api

/**
 * Created by oahgnez on 2018/8/13.
 */
object YiYanApiBuilder : ApiBuilder() {
    override val baseUrl = "https://v1.hitokoto.cn/"

    val api: YiYanApi by lazy { build().create(YiYanApi::class.java) }
}