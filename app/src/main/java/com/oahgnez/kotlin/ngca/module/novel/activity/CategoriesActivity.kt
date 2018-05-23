package com.oahgnez.kotlin.ngca.module.novel.activity

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.oahgnez.kotlin.drlbbbie.base.MvpActivity
import com.oahgnez.kotlin.ngca.R
import com.oahgnez.kotlin.ngca.module.novel.constract.CategoriesConstract
import com.oahgnez.kotlin.ngca.module.novel.model.CatModel
import com.oahgnez.kotlin.ngca.module.novel.presenter.CategoriesPresenterImpl

/**
 * Created by oahgnez on 2018/5/22.
 */

class CategoriesActivity : MvpActivity<CategoriesConstract.CategoriesView, CategoriesPresenterImpl>(), CategoriesConstract.CategoriesView {
    lateinit var mRvMale: RecyclerView
    lateinit var mAdapter: BaseQuickAdapter<CatModel, BaseViewHolder>
    override fun createPresenter(): CategoriesPresenterImpl {
        return CategoriesPresenterImpl()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)
        init()
        mPresenter.getCats()
    }

    override fun findView() {
        super.findView()
        mRvMale = findViewById(R.id.rv_male)
    }

    override fun setContent() {
        super.setContent()
        mRvMale.layoutManager = GridLayoutManager(this, 3)
        mAdapter = object : BaseQuickAdapter<CatModel, BaseViewHolder>(R.layout.item_category) {
            override fun convert(helper: BaseViewHolder?, item: CatModel?) {
                helper?.setText(R.id.tv_name, item?.name)
                helper?.setText(R.id.tv_count, "${item?.bookCount}")
            }
        }
        mRvMale.adapter = mAdapter
    }

}