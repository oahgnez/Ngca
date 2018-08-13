package com.oahgnez.kotlin.ngca.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by oahgnez on 2018/5/22.
 */
abstract class MvpPresenter<V : MvpView> {
    protected lateinit var mView: V
    private lateinit var mDisposable: CompositeDisposable

    fun bindView(v: V) {
        mView = v
    }

    fun unBindView() {
        if (::mDisposable.isInitialized) {
            mDisposable.dispose()
        }
    }

    fun addDisposable(s: Disposable) {
        if (!::mDisposable.isInitialized) {
            mDisposable = CompositeDisposable()
        }
        mDisposable.add(s)
    }

}
