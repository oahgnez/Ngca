package com.oahgnez.kotlin.ngca.module.main.model.impl

import com.oahgnez.kotlin.ngca.module.main.api.YiYanApiBuilder
import com.oahgnez.kotlin.ngca.module.main.model.IYiYan
import com.oahgnez.kotlin.ngca.module.main.model.data.YiYan
import io.reactivex.Observable

/**
 * Created by oahgnez on 2018/8/7.
 */
object YiYanDataManager:IYiYan{
    override fun getYiYan(type:String):Observable<YiYan> {
        return YiYanApiBuilder.api.getYiYan(type)
    }

    override fun loadData() {

    }

}