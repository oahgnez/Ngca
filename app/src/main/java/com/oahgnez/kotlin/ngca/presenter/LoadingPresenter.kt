package com.oahgnez.kotlin.ngca.presenter

import com.oahgnez.kotlin.ngca.api.PixivApiBuilder
import com.oahgnez.kotlin.ngca.base.MvpPresenter
import com.oahgnez.kotlin.ngca.model.data.PixivListResult
import com.oahgnez.kotlin.ngca.contract.LoadingContract
import com.oahgnez.kotlin.ngca.model.data.YiYan
import com.oahgnez.kotlin.ngca.model.impl.YiYanDataManager
import com.oahgnez.kotlin.ngca.util.ScheduleTransform
import io.reactivex.observers.DisposableObserver

/**
 * Created by oahgnez on 2018/8/7.
 */
class LoadingPresenter : MvpPresenter<LoadingContract.IView>(), LoadingContract.IPresenter {
    override fun getImage() {
        addDisposable(PixivApiBuilder
                .api
                .rank()
                .compose(ScheduleTransform<PixivListResult>())
                .subscribeWith(object : DisposableObserver<PixivListResult>() {
                    override fun onComplete() {

                    }

                    override fun onNext(t: PixivListResult) {
                        mView.showImage(t.illusts[0])
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }

                }))
    }

    override fun getWord() {
        addDisposable(YiYanDataManager
                .getYiYan()
                .compose(ScheduleTransform<YiYan>())
                .subscribeWith(object : DisposableObserver<YiYan>() {
                    override fun onComplete() {

                    }

                    override fun onNext(t: YiYan) {
                        mView.showWord(t)
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }

                }))
    }

}