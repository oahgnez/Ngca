package com.oahgnez.kotlin.ngca.model.impl

import com.oahgnez.kotlin.ngca.api.YiYanApiBuilder
import com.oahgnez.kotlin.ngca.model.IYiYan
import com.oahgnez.kotlin.ngca.model.data.YiYan
import io.reactivex.Observable

/**
 * Created by oahgnez on 2018/8/7.
 */
object YiYanDataManager: IYiYan {
    override fun getYiYan(type:String):Observable<YiYan> {
        return YiYanApiBuilder.api.getYiYan(type)
    }

    override fun loadData() {

    }

}