package com.oahgnez.kotlin.ngca.model

import com.oahgnez.kotlin.ngca.java.Types
import com.oahgnez.kotlin.ngca.model.data.YiYan
import io.reactivex.Observable

/**
 * Created by oahgnez on 2018/8/13.
 */
interface IYiYan {
    fun getYiYan(@Types.YiYanType type:String= Types.YIYAN_ANIME): Observable<YiYan>
    fun loadData()
}