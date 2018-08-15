package com.oahgnez.kotlin.ngca.presenter.novel

import android.widget.Toast
import com.oahgnez.kotlin.ngca.app.NgcaApp
import com.oahgnez.kotlin.ngca.api.NovelApiBuilder
import com.oahgnez.kotlin.ngca.contract.novel.BooksContract
import com.oahgnez.kotlin.ngca.fragment.novel.BooksFragment
import com.oahgnez.kotlin.ngca.model.data.BookResults
import com.oahgnez.kotlin.ngca.model.data.RankResultModel
import com.oahgnez.kotlin.ngca.base.MvpPresenter
import com.oahgnez.kotlin.ngca.util.ScheduleTransform
import io.reactivex.observers.DisposableObserver

/**
 * Created by oahgnez on 2018/6/5.
 */
class BooksPresenter(val type: Int = 0, val gender: String? = null, val cat: String? = null, val major: String? = null, val tags: List<String>) : MvpPresenter<BooksContract.IView>(), BooksContract.IPresenter {

    companion object {
        private const val LIMIT = 20
    }

    var mPagerIndex = 0
    override fun getBooks(tagIndex: Int, isMore: Boolean) {
        when (type) {
            BooksFragment.TYPE_CAT -> getBooksByCat(tags[tagIndex], isMore)
            BooksFragment.TYPE_RANK -> getBooksByRank(tags[tagIndex])
        }
    }

    fun getBooksByCat(minor: String, isMore: Boolean) {
        addDisposable(NovelApiBuilder.api
                .getBooksByCat(gender!!, cat!!, major!!, minor, mPagerIndex, LIMIT)
                .compose(ScheduleTransform<BookResults>())
                .subscribeWith(object : DisposableObserver<BookResults>() {
                    override fun onNext(t: BookResults) {
                        if (t.ok) {
                            mView?.showBooks(t.books, isMore)
                            mPagerIndex++
                        } else {
                            Toast.makeText(NgcaApp.instance, "加载失败", Toast.LENGTH_SHORT).show()
                            if (isMore) {
                                mView?.loadMoreFail()
                            } else {

                            }
                        }
                    }

                    override fun onError(e: Throwable) {
                        Toast.makeText(NgcaApp.instance, "加载失败", Toast.LENGTH_SHORT).show()
                    }

                    override fun onComplete() {
                    }

                }))
    }

    fun getBooksByRank(rankId: String) {
        addDisposable(NovelApiBuilder.api
                .getBooksByRank(rankId)
                .compose(ScheduleTransform<RankResultModel>())
                .subscribeWith(object : DisposableObserver<RankResultModel>() {
                    override fun onNext(t: RankResultModel) {
                        if (t.ok) {
                            mView?.showBooks(t.ranking.books)
//                        mPagerIndex++
                        }
                    }

                    override fun onError(e: Throwable) {

                    }

                    override fun onComplete() {

                    }
                }))
    }


}