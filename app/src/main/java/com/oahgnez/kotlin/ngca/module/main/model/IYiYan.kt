package com.oahgnez.kotlin.ngca.module.main.model

import com.oahgnez.kotlin.ngca.java.Types
import com.oahgnez.kotlin.ngca.module.main.model.data.YiYan
import io.reactivex.Observable

/**
 * Created by oahgnez on 2018/8/13.
 */
interface IYiYan {
    fun getYiYan(@Types.YiYanType type:String): Observable<YiYan>
    fun loadData()
}