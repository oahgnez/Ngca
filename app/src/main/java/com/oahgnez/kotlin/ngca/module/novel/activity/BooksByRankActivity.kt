package com.oahgnez.kotlin.ngca.module.novel.activity

import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v4.widget.SwipeRefreshLayout
import com.alibaba.android.arouter.facade.annotation.Route
import com.oahgnez.kotlin.ngca.R
import com.oahgnez.kotlin.ngca.base.MvpActivity
import com.oahgnez.kotlin.ngca.module.novel.contract.BooksByRankContract
import com.oahgnez.kotlin.ngca.module.novel.fragment.Fragment
import com.oahgnez.kotlin.ngca.module.novel.data.model.RankGenderResults
import com.oahgnez.kotlin.ngca.module.novel.presenter.BooksByRankPresenter
import com.oahgnez.kotlin.ngca.route.INRoute
import com.oahgnez.kotlin.ngca.widget.BaseFragmentAdapter
import kotlinx.android.synthetic.main.activity_books_by_cats.*

/**
 * Created by oahgnez on 2018/7/6.
 * 排行 小说列表
 */

@Route(path = INRoute.ROUTE_BOOKS_BY_RANK)
class BooksByRankActivity : MvpActivity<BooksByRankContract.IView, BooksByRankPresenter>(), BooksByRankContract.IView {
    override fun showInit(data: RankGenderResults) {
        refresh_layout.isRefreshing=false
        val fragments = ArrayList<Fragment>()
        fragments.add(Fragment.newRankInstance(data.male))
        fragments.add(Fragment.newRankInstance(data.female ))
        fragments.add(Fragment.newRankInstance(data.picture ))
        fragments.add(Fragment.newRankInstance(data.epub ))
        mFragmentsAdapter = BaseFragmentAdapter(supportFragmentManager, fragments)
        mViewPager.adapter = mFragmentsAdapter
        mTabType.setupWithViewPager(mViewPager)

        mTabType.getTabAt(0)?.text = getString(R.string.male)
        mTabType.getTabAt(1)?.text = getString(R.string.female)
        mTabType.getTabAt(2)?.text = getString(R.string.picture)
        mTabType.getTabAt(3)?.text = getString(R.string.press)
    }


    lateinit var mTabType: TabLayout
    lateinit var mRefreshLayout: SwipeRefreshLayout
    lateinit var mViewPager: ViewPager
    lateinit var mAppbarLayout: AppBarLayout
    lateinit var mFragmentsAdapter: BaseFragmentAdapter<Fragment>

    override fun createPresenter(): BooksByRankPresenter {
        return BooksByRankPresenter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setTransparentStatusBar()
        setContentView(R.layout.activity_books_by_cats)
        initView()
    }


    override fun findView() {
        super.findView()
        mTabType = findViewById(R.id.tab_type)
        mViewPager = findViewById(R.id.viewpager)
        mRefreshLayout = findViewById(R.id.refresh_layout)
        mAppbarLayout = findViewById(R.id.appbar_layout)
    }

    override fun setContent() {
        mRefreshLayout.isRefreshing=true
        mPresenter?.getRankGenders()
    }

    override fun setListener() {
        super.setListener()
        toolbar.setNavigationOnClickListener { _ -> finish() }

        mAppbarLayout.addOnOffsetChangedListener { _, verticalOffset ->
            if (!mRefreshLayout.isRefreshing) {
                mRefreshLayout.isEnabled = verticalOffset >= 0
            }
        }

        mViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                if (position == 0) {
                    slidr.unlock()
                } else {
                    slidr.lock()
                }
            }
        })
        mTabType.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
                mFragmentsAdapter.getFragment(tab?.position ?: 0).scrollToStart()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {

            }
        })

        mRefreshLayout.setOnRefreshListener { mFragmentsAdapter.getFragment(mViewPager.currentItem).refresh() }
//        StatusBarUtil.setTranslucent(this)
    }

    fun loadSuccess() {
        mRefreshLayout.isRefreshing = false
    }


}