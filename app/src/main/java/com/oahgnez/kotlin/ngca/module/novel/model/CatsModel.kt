package com.oahgnez.kotlin.ngca.module.novel.model

import java.io.Serializable

/**
 * Created by oahgnez on 2018/5/22.
 */

data class CatsModel(var ok: Boolean,
                     var male: List<CatModel>,
                     var female: List<CatModel>,
                     var picture: List<CatModel>,
                     var press: List<CatModel>):Serializable