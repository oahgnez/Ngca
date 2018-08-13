package com.oahgnez.kotlin.ngca.module.novel.data.model

import java.io.Serializable

/**
 * Created by oahgnez on 2018/5/22.
 */
data class RankGenderResults(var ok: Boolean,
                             var male: ArrayList<RankGender>,
                             var female: ArrayList<RankGender>,
                             var epub: ArrayList<RankGender>,
                             var picture: ArrayList<RankGender>):Serializable