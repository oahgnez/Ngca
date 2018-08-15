package com.oahgnez.kotlin.ngca.activity

import android.os.Bundle
import com.bumptech.glide.Glide
import com.oahgnez.kotlin.ngca.R
import com.oahgnez.kotlin.ngca.contract.LoadingContract
import com.oahgnez.kotlin.ngca.model.data.YiYan
import com.oahgnez.kotlin.ngca.presenter.LoadingPresenter
import com.bumptech.glide.load.model.LazyHeaders
import com.bumptech.glide.load.model.GlideUrl
import com.oahgnez.kotlin.ngca.api.PixivApi
import com.oahgnez.kotlin.ngca.base.MvpActivity
import com.oahgnez.kotlin.ngca.model.data.PixivImage
import kotlinx.android.synthetic.main.activity_loading.*


/**
 * Created by oahgnez on 2018/8/14.
 */
class LoadingActivity: MvpActivity<LoadingContract.IView, LoadingPresenter>(), LoadingContract.IView{
    override fun createPresenter(): LoadingPresenter {
        return LoadingPresenter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)
        mPresenter.getImage()
//        mPresenter.getWord()
    }

    override fun showImage(t: PixivImage) {
        val url = PixivApi.s + t.image_urls.medium
        val cookie = GlideUrl(url, LazyHeaders.Builder().addHeader("Referer", "https://api.imjad.cn/pixiv_v2.md").build())
        Glide.with(this@LoadingActivity)
                .load(cookie)
                .into(iv_loading)
    }

    override fun showWord(data: YiYan) {
        tv_content.text=data.hitokoto
        tv_author.text=data.from
    }
}