package com.oahgnez.kotlin.drlbbbie.base

import android.os.Bundle

/**
 * Created by oahgnez on 2018/5/22.
 */
abstract class MvpActivity<V : MvpView, P : MvpPresenter<V>> : BaseActivity(), MvpView {

    protected val mPresenter by lazy { createPresenter() }

    abstract fun createPresenter(): P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter.bindView(this as V)
    }

    override fun onDestroy() {
        mPresenter.unBindView()
        super.onDestroy()
    }

}