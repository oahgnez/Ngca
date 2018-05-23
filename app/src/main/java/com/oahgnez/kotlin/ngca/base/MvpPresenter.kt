package com.oahgnez.kotlin.drlbbbie.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by oahgnez on 2018/5/22.
 */
abstract class MvpPresenter< V: MvpView> {
     protected var mView: V? = null
     private var mDisposable: CompositeDisposable? = null

    fun bindView(v: V) {
        mView = v
    }

    fun unBindView() {
        mDisposable?.dispose()
        mView = null
    }

    fun addDisposable(s: Disposable) {
        if (mDisposable == null) {
            mDisposable = CompositeDisposable()
        }
        mDisposable?.add(s)
    }

}
