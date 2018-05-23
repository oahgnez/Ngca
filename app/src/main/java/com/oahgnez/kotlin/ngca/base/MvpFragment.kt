package com.oahgnez.kotlin.drlbbbie.base

import android.os.Bundle
import com.oahgnez.kotlin.ngca.base.BaseFragment

/**
 * Created by oahgnez on 2018/5/22.
 */
abstract class MvpFragment<V : MvpView, P : MvpPresenter<V>> : BaseFragment(), MvpView {
    protected val mPresenter by lazy { createPresenter() }

    abstract fun createPresenter(): P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter.bindView(this as V)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mPresenter.unBindView()
    }
}