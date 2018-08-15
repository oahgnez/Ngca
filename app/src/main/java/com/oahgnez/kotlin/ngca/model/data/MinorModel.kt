package com.oahgnez.kotlin.ngca.model.data

import java.io.Serializable

/**
 * Created by oahgnez on 2018/5/22.
 */
data class MinorModel(var major:String,
                      var mins:List<String>):Serializable

//{"major":"玄幻","mins":["东方玄幻","异界大陆","异界争霸","远古神话"]}
