package com.oahgnez.kotlin.ngca.base

import android.os.Bundle

/**
 * Created by oahgnez on 2018/5/22.
 */
abstract class MvpActivity<V : MvpView, P : MvpPresenter<V>> : BaseActivity(),MvpView {

    protected lateinit var mPresenter: P

    abstract fun createPresenter(): P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter=createPresenter()
        mPresenter.bindView(this as V)
    }

    override fun onDestroy() {
        mPresenter.unBindView()
        super.onDestroy()
    }

}