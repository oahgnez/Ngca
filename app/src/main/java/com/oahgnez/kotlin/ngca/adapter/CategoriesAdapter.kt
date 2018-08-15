package com.oahgnez.kotlin.ngca.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.oahgnez.kotlin.ngca.R
import com.oahgnez.kotlin.ngca.model.data.Major

/**
 * Created by oahgnez on 2018/5/23.
 */
class CategoriesAdapter : BaseQuickAdapter<Major, BaseViewHolder> {
    constructor() : super(R.layout.item_category)
    constructor(data: List<Major>) : super(R.layout.item_category, data)

    override fun convert(helper: BaseViewHolder?, item: Major?) {
        helper?.setText(R.id.tv_name, item?.name)
        helper?.setText(R.id.tv_count, "${item?.bookCount}")
    }



}