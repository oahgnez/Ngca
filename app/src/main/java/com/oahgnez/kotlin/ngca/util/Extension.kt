package com.oahgnez.kotlin.ngca.util

import com.oahgnez.kotlin.ngca.base.BaseActivity
import com.oahgnez.kotlin.ngca.base.MvpPresenter
import com.oahgnez.kotlin.ngca.base.MvpView
import com.oahgnez.kotlin.ngca.base.BaseFragment

/**
 * Created by oahgnez on 2018/5/22.
 */
val BaseActivity.TAG: String
    get() = this.javaClass.simpleName

val BaseFragment.TAG: String
    get() = this.javaClass.simpleName

val <V : MvpView>MvpPresenter<V>.TAG: String
    get() = this.javaClass.simpleName