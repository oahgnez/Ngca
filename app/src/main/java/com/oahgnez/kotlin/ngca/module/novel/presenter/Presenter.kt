package com.oahgnez.kotlin.ngca.module.novel.presenter

import android.widget.Toast
import com.oahgnez.kotlin.ngca.base.MvpPresenter
import com.oahgnez.kotlin.ngca.app.NgcaApp
import com.oahgnez.kotlin.ngca.module.novel.api.NovelApiBuilder
import com.oahgnez.kotlin.ngca.module.novel.contract.BookInfoContract
import com.oahgnez.kotlin.ngca.module.novel.data.model.BookInfo
import com.oahgnez.kotlin.ngca.util.ScheduleTransform
import io.reactivex.observers.DisposableObserver

/**
 * Created by oahgnez on 2018/6/5.
 */
class Presenter : MvpPresenter<BookInfoContract.View>(), BookInfoContract.IPresenter {
    override fun getBookInfo(id: String) {
        addDisposable(NovelApiBuilder
                .api
                .getBookInfo(id)
                .compose(ScheduleTransform<BookInfo>())
                .subscribeWith(object : DisposableObserver<BookInfo>() {
                    override fun onComplete() {

                    }

                    override fun onError(e: Throwable) {
                        Toast.makeText(NgcaApp.instance,"失败",Toast.LENGTH_SHORT).show()
                        e.printStackTrace()
                    }

                    override fun onNext(t: BookInfo) {
                        mView?.showInfo(t)
                    }

                }))
    }

}