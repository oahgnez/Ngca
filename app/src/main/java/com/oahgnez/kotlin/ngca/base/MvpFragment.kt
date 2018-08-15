package com.oahgnez.kotlin.ngca.base

import android.os.Bundle

/**
 * Created by oahgnez on 2018/5/22.
 */
abstract class MvpFragment<V : MvpView, P : MvpPresenter<V>> : BaseFragment(), MvpView {
    protected lateinit var mPresenter: P
    abstract fun createPresenter(): P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter = createPresenter()
        mPresenter.bindView(this as V)
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.unBindView()
    }


}