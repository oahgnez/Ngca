package com.oahgnez.kotlin.ngca.adapter

import android.support.v4.content.ContextCompat
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.oahgnez.kotlin.ngca.R

/**
 * Created by oahgnez on 2018/5/31.
 */
class TagsAdapter(data: List<String>?) : BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_tag, data) {
    private var old = -1
    var selected = 0
    private val colorTextSecondary by lazy { ContextCompat.getColor(mContext, R.color.colorTextSecondary) }
    private val colorAccent by lazy { ContextCompat.getColor(mContext, R.color.colorAccent) }
    private val colorWhite by lazy { ContextCompat.getColor(mContext, R.color.colorWhite) }
    private val colorTransparent by lazy { ContextCompat.getColor(mContext, android.R.color.transparent) }

    override fun convert(helper: BaseViewHolder?, item: String?) {
        helper?.setText(R.id.tv_tag, item)
    }


    override fun onBindViewHolder(holder: BaseViewHolder?, position: Int) {
        if (position == selected) {
            holder?.itemView?.setBackgroundColor(colorWhite)
            holder?.setTextColor(R.id.tv_tag, colorAccent)
        }else {
            holder?.itemView?.setBackgroundColor(colorTransparent)
            holder?.setTextColor(R.id.tv_tag, colorTextSecondary)
        }
        super.onBindViewHolder(holder, position)
    }

    fun setSelect(position: Int) {
        old = selected
        selected = position
        notifyItemChanged(old)
        notifyItemChanged(selected)
    }

}