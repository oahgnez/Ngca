package com.oahgnez.kotlin.ngca.module.novel.activity

import android.Manifest
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Route
import com.oahgnez.kotlin.ngca.base.MvpActivity
import com.oahgnez.kotlin.ngca.R
import com.oahgnez.kotlin.ngca.java.Types
import com.oahgnez.kotlin.ngca.module.novel.adapter.CategoriesAdapter
import com.oahgnez.kotlin.ngca.module.novel.contract.MajorsContract
import com.oahgnez.kotlin.ngca.module.novel.data.model.Major
import com.oahgnez.kotlin.ngca.module.novel.presenter.MajorsPresenter
import com.oahgnez.kotlin.ngca.route.INRoute
import com.oahgnez.kotlin.ngca.route.NovelRoute
import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.observers.DisposableObserver
import kotlinx.android.synthetic.main.activity_majors.*

/**
 * Created by oahgnez on 2018/5/22.
 * 小说分类页面
 */
@Route(path = INRoute.ROUTE_MAJORS)
class MajorsActivity : MvpActivity<MajorsContract.IView, MajorsPresenter>(), MajorsContract.IView {
    private lateinit var mRvMale: RecyclerView
    private lateinit var mRvFemale: RecyclerView
    private lateinit var mRvPicture: RecyclerView
    private lateinit var mRvPress: RecyclerView
    private val mMaleAdapter by lazy { CategoriesAdapter() }
    private val mFemaleAdapter by lazy { CategoriesAdapter() }
    private val mPictureAdapter by lazy { CategoriesAdapter() }
    private val mPressAdapter by lazy { CategoriesAdapter() }
    override fun createPresenter(): MajorsPresenter {
        return MajorsPresenter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_majors)
        initView()
        RxPermissions(this).request(Manifest.permission.INTERNET).subscribeWith(object : DisposableObserver<Boolean>() {
            override fun onError(e: Throwable) {
                Toast.makeText(baseContext, "授权失败", Toast.LENGTH_SHORT).show()
            }

            override fun onComplete() {

            }

            override fun onNext(t: Boolean) {
                if (t) {
                    mPresenter.getCats()
                }
            }

        })

    }

    override fun findView() {
        super.findView()
        mRvMale = findViewById(R.id.rv_male)
        mRvFemale = findViewById(R.id.rv_female)
        mRvPicture = findViewById(R.id.rv_picture)
        mRvPress = findViewById(R.id.rv_press)
    }

    override fun setContent() {
        super.setContent()
        mRvMale.layoutManager = GridLayoutManager(this, 3)
        mRvFemale.layoutManager = GridLayoutManager(this, 3)
        mRvPress.layoutManager = GridLayoutManager(this, 3)
        mRvPicture.layoutManager = GridLayoutManager(this, 3)
        mRvMale.adapter = mMaleAdapter
        mRvFemale.adapter = mFemaleAdapter
        mRvPicture.adapter = mPictureAdapter
        mRvPress.adapter = mPressAdapter
        mPresenter.getMinors()
    }

    override fun setListener() {
        super.setListener()
        mMaleAdapter.setOnItemClickListener { _, _, position ->
            mPresenter.toBooks(Types.MALE, position)
        }
        mFemaleAdapter.setOnItemClickListener { _, _, position ->
            mPresenter.toBooks(Types.FEMALE, position)
        }
        mPictureAdapter.setOnItemClickListener { _, _, position ->
            mPresenter.toBooks(Types.PICTURE, position)
        }
        mPressAdapter.setOnItemClickListener { _, _, position ->
            mPresenter.toBooks(Types.PRESS, position)
        }
        toolbar.setOnClickListener { NovelRoute.toBooksByRank() }
    }

    override fun setMaleCats(majors: List<Major>) {
        mMaleAdapter.addData(majors)
    }

    override fun setFemaleCats(majors: List<Major>) {
        mFemaleAdapter.addData(majors)
    }

    override fun setPictureCats(majors: List<Major>) {
        mPictureAdapter.addData(majors)
    }

    override fun setPressCats(majors: List<Major>) {
        mPressAdapter.addData(majors)
    }

}

