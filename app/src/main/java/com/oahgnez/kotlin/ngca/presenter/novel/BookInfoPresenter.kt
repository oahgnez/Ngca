package com.oahgnez.kotlin.ngca.presenter.novel

import android.widget.Toast
import com.oahgnez.kotlin.ngca.app.NgcaApp
import com.oahgnez.kotlin.ngca.api.NovelApiBuilder
import com.oahgnez.kotlin.ngca.contract.novel.BookInfoContract
import com.oahgnez.kotlin.ngca.model.data.BookInfo
import com.oahgnez.kotlin.ngca.base.MvpPresenter
import com.oahgnez.kotlin.ngca.util.ScheduleTransform
import io.reactivex.observers.DisposableObserver

/**
 * Created by oahgnez on 2018/6/5.
 */
class BookInfoPresenter : MvpPresenter<BookInfoContract.View>(), BookInfoContract.IPresenter {
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