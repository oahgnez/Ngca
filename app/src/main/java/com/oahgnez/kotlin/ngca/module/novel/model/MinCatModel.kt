package com.oahgnez.kotlin.ngca.module.novel.model

import java.io.Serializable

/**
 * Created by oahgnez on 2018/5/22.
 */
data class MinCatModel(var major:String,
                       var mins:List<String>):Serializable

//{"major":"玄幻","mins":["东方玄幻","异界大陆","异界争霸","远古神话"]}
