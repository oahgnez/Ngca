package com.oahgnez.kotlin.ngca.module.novel.activity

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.oahgnez.kotlin.ngca.base.MvpActivity
import com.oahgnez.kotlin.ngca.R
import com.oahgnez.kotlin.ngca.module.novel.contract.BookInfoContract
import com.oahgnez.kotlin.ngca.module.novel.data.model.BookInfo
import com.oahgnez.kotlin.ngca.module.novel.presenter.Presenter
import com.oahgnez.kotlin.ngca.route.INRoute
import kotlinx.android.synthetic.main.activity_book_info.*

/**
 * Created by oahgnez on 2018/6/5.
 */
@Route(path = INRoute.ROUTE_BOOK_INFO)
class BookInfoActivity:MvpActivity<BookInfoContract.View, Presenter>(), BookInfoContract.View {
    val bookId by lazy { intent.getStringExtra(INRoute.EXTRA_BOOK_ID) }
    override fun createPresenter(): Presenter {
        return Presenter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_info)
        initView()
        mPresenter?.getBookInfo(bookId)
    }

    override fun findView() {

    }
    override fun showInfo(data: BookInfo) {
        tv_long_intro.text = data.longIntro
    }

}