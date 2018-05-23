package com.oahgnez.kotlin.ngca.module.novel.model

import java.io.Serializable

/**
 * Created by oahgnez on 2018/5/22.
 */
data class RankGendersModel(var ok: Boolean,
                     var male: List<RankGenderModel>,
                     var female: List<RankGenderModel>,
                     var epub: List<RankGenderModel>,
                     var press: List<RankGenderModel>):Serializable