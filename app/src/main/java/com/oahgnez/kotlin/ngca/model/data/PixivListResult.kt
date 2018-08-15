package com.oahgnez.kotlin.ngca.model.data

import java.io.Serializable

/**
 * Created by oahgnez on 2018/8/14.
 */
data class PixivListResult(var illusts:List<PixivImage>, var next_url:String):Serializable