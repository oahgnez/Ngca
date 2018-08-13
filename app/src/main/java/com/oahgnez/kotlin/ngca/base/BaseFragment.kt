package com.oahgnez.kotlin.ngca.base

import android.view.View
import com.trello.rxlifecycle2.components.support.RxFragment

/**
 * Created by oahgnez on 2018/5/22.
 */
abstract class BaseFragment : RxFragment() {
    var mRootView: View? = null
    open fun findView() {}
    open fun setContent() {}
    open fun setListener() {}
    fun initView() {
        findView()
        setContent()
        setListener()
    }
}