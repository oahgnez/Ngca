package com.oahgnez.kotlin.ngca.app

import android.app.Application
import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter
import com.oahgnez.kotlin.ngca.BuildConfig

/**
 * Created by oahgnez on 2018/6/4.
 */
class NgcaApp : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
        instance = this
    }
    companion object {
        lateinit var instance :Context
    }

}