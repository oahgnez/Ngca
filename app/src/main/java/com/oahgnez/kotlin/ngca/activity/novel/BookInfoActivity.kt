package com.oahgnez.kotlin.ngca.activity.novel

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.oahgnez.kotlin.ngca.base.MvpActivity
import com.oahgnez.kotlin.ngca.R
import com.oahgnez.kotlin.ngca.contract.novel.BookInfoContract
import com.oahgnez.kotlin.ngca.model.data.BookInfo
import com.oahgnez.kotlin.ngca.presenter.novel.BookInfoPresenter
import com.oahgnez.kotlin.ngca.route.INRoute
import kotlinx.android.synthetic.main.activity_book_info.*

/**
 * Created by oahgnez on 2018/6/5.
 */
@Route(path = INRoute.ROUTE_BOOK_INFO)
class BookInfoActivity: MvpActivity<BookInfoContract.View, BookInfoPresenter>(), BookInfoContract.View {
    val bookId by lazy { intent.getStringExtra(INRoute.EXTRA_BOOK_ID) }
    override fun createPresenter(): BookInfoPresenter {
        return BookInfoPresenter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_info)
        initView()
        mPresenter.getBookInfo(bookId)
    }

    override fun findView() {

    }
    override fun showInfo(data: BookInfo) {
        tv_long_intro.text = data.longIntro
    }

}