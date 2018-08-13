package com.oahgnez.kotlin.ngca.module.novel.adapter

import android.content.res.Resources
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.oahgnez.kotlin.ngca.R
import com.oahgnez.kotlin.ngca.module.novel.api.NovelApiBuilder.STATIC_URL
import com.oahgnez.kotlin.ngca.module.novel.data.model.Book

/**
 * Created by oahgnez on 2018/5/31.
 */
class BookInfoAdapter(data: List<Book>?) : BaseQuickAdapter<Book, BaseViewHolder>(R.layout.item_book_info, data) {

    constructor():this(null)
    override fun convert(helper: BaseViewHolder?, item: Book?) {
        helper?.setText(R.id.tv_title,item?.title)
        val resources :Resources


        helper?.setText(R.id.tv_author,item?.author)
        helper?.setText(R.id.tv_des,item?.shortIntro)
        helper?.setText(R.id.tv_data,"人气:${item?.latelyFollower} | 留存:${item?.retentionRatio}%")
        Glide.with(mContext)
                .load(STATIC_URL+item?.cover)
                .into(helper!!.itemView!!.findViewById(R.id.iv_cover))
    }


}