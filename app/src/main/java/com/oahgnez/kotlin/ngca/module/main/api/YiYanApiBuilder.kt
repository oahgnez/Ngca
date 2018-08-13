package com.oahgnez.kotlin.ngca.module.main.api

import com.oahgnez.kotlin.ngca.base.ApiBuilder

/**
 * Created by oahgnez on 2018/8/13.
 */
object YiYanApiBuilder : ApiBuilder() {
    override val baseUrl = "https://v1.hitokoto.cn/"
    val api: YiYanApi by lazy { build().create(YiYanApi::class.java) }
}