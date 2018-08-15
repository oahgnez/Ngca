package com.oahgnez.kotlin.ngca.contract.novel

import com.oahgnez.kotlin.ngca.base.MvpView
import com.oahgnez.kotlin.ngca.model.data.BookInfo

/**
 * Created by oahgnez on 2018/6/5.
 */
interface BookInfoContract {
    interface View :MvpView{
        fun showInfo(data: BookInfo)

    }

    interface IPresenter {
        fun getBookInfo(id:String)
    }
}