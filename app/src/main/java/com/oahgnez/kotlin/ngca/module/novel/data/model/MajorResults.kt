package com.oahgnez.kotlin.ngca.module.novel.data.model

import java.io.Serializable

/**
 * Created by oahgnez on 2018/5/22.
 */

data class MajorResults(var ok: Boolean,
                        var male: List<Major>,
                        var female: List<Major>,
                        var picture: List<Major>,
                        var presses: List<Major>):Serializable