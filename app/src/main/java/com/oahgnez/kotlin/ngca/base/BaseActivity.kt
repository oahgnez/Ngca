package com.oahgnez.kotlin.ngca.base

import android.os.Bundle
import android.support.v4.content.ContextCompat
import com.jaeger.library.StatusBarUtil
import com.oahgnez.kotlin.ngca.R
import com.r0adkll.slidr.Slidr
import com.r0adkll.slidr.model.SlidrConfig
import com.r0adkll.slidr.model.SlidrInterface
import com.r0adkll.slidr.model.SlidrPosition
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity

/**
 * Created by oahgnez on 2018/5/22.
 */
abstract class BaseActivity : RxAppCompatActivity() {
    open val needSlidr = true
    protected lateinit var slidr:SlidrInterface
    open fun findView() {}
    open fun setContent() {}
    open fun setListener() {}

    open fun initView() {
        if(needSlidr){
            setSlid()
        }
        findView()
        setContent()
        setListener()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStatusBar()
    }

    open fun setStatusBar() {
        StatusBarUtil.setColorNoTranslucent(this, ContextCompat.getColor(this@BaseActivity, R.color.colorWhite))
    }


    private fun setSlid() {
        val config = SlidrConfig.Builder()
                .position(SlidrPosition.LEFT)
                .edge(false)
                .edgeSize(1.0f)
                .build()
        slidr=Slidr.attach(this, config)
    }
}




