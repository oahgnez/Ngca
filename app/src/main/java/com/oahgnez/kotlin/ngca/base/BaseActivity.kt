package com.oahgnez.kotlin.drlbbbie.base

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity

/**
 * Created by oahgnez on 2018/5/22.
 */
abstract class BaseActivity : RxAppCompatActivity() {
    open fun findView() {}
    open fun setContent() {}
    open fun setListener() {}
    fun init() {
        findView()
        setContent()
        setListener()
    }
}




