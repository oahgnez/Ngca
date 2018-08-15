package com.oahgnez.kotlin.ngca.model.data

import java.io.Serializable

/**
 * Created by oahgnez on 2018/5/22.
 */


data class MinorResults(var ok: Boolean,
                        var male: List<MinorModel>,
                        var female: List<MinorModel>,
                        var picture: List<MinorModel>,
                        var press: List<MinorModel>): Serializable

/*/*{"male":[{"major":"玄幻","mins":["东方玄幻","异界大陆","异界争霸","远古神话"]},
{"major":"奇幻","mins":["西方奇幻","领主贵族","亡灵异族","魔法校园"]},
{"major":"武侠","mins":["传统武侠","新派武侠","国术武侠"]},
{"major":"仙侠","mins":["古典仙侠","幻想修仙","现代修仙","洪荒封神"]},
{"major":"都市","mins":["都市生活","爱情婚姻","异术超能","恩怨情仇","青春校园","现实百态"]},
....
 */