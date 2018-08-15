package com.oahgnez.kotlin.ngca.contract.novel

import com.oahgnez.kotlin.ngca.base.MvpView
import com.oahgnez.kotlin.ngca.model.data.Book

/**
 * Created by oahgnez on 2018/6/5.
 */
interface BooksContract {
    interface IView :MvpView{
        fun showBooks(data: List<Book>, isMore: Boolean = false)
        fun scrollToStart()
        fun loadMoreFail()
        fun refresh()

    }

    interface IPresenter {
        fun getBooks(tagIndex:Int, isMore: Boolean = false)
    }
}