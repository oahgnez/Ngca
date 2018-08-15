package com.oahgnez.kotlin.ngca.fragment.novel

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.oahgnez.kotlin.ngca.base.MvpFragment
import com.oahgnez.kotlin.ngca.R
import com.oahgnez.kotlin.ngca.activity.novel.BooksByCatsActivity
import com.oahgnez.kotlin.ngca.activity.novel.BooksByRankActivity
import com.oahgnez.kotlin.ngca.adapter.BookInfoAdapter
import com.oahgnez.kotlin.ngca.adapter.TagsAdapter
import com.oahgnez.kotlin.ngca.contract.novel.BooksContract
import com.oahgnez.kotlin.ngca.model.data.Book
import com.oahgnez.kotlin.ngca.model.data.RankGender
import com.oahgnez.kotlin.ngca.presenter.novel.BooksPresenter
import com.oahgnez.kotlin.ngca.route.INRoute
import com.oahgnez.kotlin.ngca.route.NovelRoute

/**
 * Created by oahgnez on 2018/6/5.
 */
class BooksFragment : MvpFragment<BooksContract.IView, BooksPresenter>(), BooksContract.IView {
    companion object {
        private const val EXTRA_TYPE = "extra_type"
        private const val EXTRA_RANK_GENDERS = "extra_rank_genders"
        const val TYPE_CAT = 1   //分类
        const val TYPE_RANK = 2   //排行榜

        fun newCatInstance(gender: String, cat: String, major: String, minors: ArrayList<String>): BooksFragment {
            val instance = BooksFragment()
            val bundle = Bundle()
            bundle.putInt(EXTRA_TYPE, TYPE_CAT)
            bundle.putString(INRoute.EXTRA_GENDER, gender)
            bundle.putString(INRoute.EXTRA_CAT, cat)
            bundle.putString(INRoute.EXTRA_MAJOR, major)
            bundle.putStringArrayList(INRoute.EXTRA_BOOK_MINORS, minors)
            instance.arguments = bundle
            return instance
        }

        fun newRankInstance(tags: ArrayList<RankGender>): BooksFragment {
            val instance = BooksFragment()
            val bundle = Bundle()
            bundle.putInt(EXTRA_TYPE, TYPE_RANK)
            bundle.putSerializable(EXTRA_RANK_GENDERS, tags)
            instance.arguments = bundle
            return instance
        }

    }

    private lateinit var mRvBooks: RecyclerView
    private lateinit var mRvTags: RecyclerView
    private lateinit var mAdapterTags: TagsAdapter
    private val mAdapterBooks by lazy { BookInfoAdapter() }

    override fun createPresenter(): BooksPresenter {
        return if (arguments.getInt(EXTRA_TYPE, TYPE_CAT) == TYPE_CAT) {
            val gender = arguments.getString(INRoute.EXTRA_GENDER)
            val major = arguments.getString(INRoute.EXTRA_MAJOR)
            val cat = arguments.getString(INRoute.EXTRA_CAT)
            val minors = arguments.getStringArrayList(INRoute.EXTRA_BOOK_MINORS)
            BooksPresenter(TYPE_CAT, gender, cat, major, tags = minors)
        } else {
            val ranks = arguments.getSerializable(EXTRA_RANK_GENDERS) as ArrayList<RankGender>
            BooksPresenter(TYPE_RANK, tags = ranks.map {
                it._id ?: ""
            })
        }


    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (mRootView == null) {
            mRootView = inflater!!.inflate(R.layout.fragment_books_by_cats, container, false)
            initView()
        }
        mPresenter?.getBooks(mAdapterTags.selected)
        return mRootView
    }

    override fun findView() {
        mRvBooks = mRootView!!.findViewById(R.id.rv_books)
        mRvTags = mRootView!!.findViewById(R.id.rv_minors)
    }

    override fun setContent() {
        mRvBooks.layoutManager = LinearLayoutManager(context)
        mRvBooks.adapter = mAdapterBooks
        mAdapterTags = if (arguments.getInt(EXTRA_TYPE, TYPE_CAT) == TYPE_RANK) {
            val tags = arguments.getSerializable(EXTRA_RANK_GENDERS) as ArrayList<RankGender>
            TagsAdapter(tags.map { it.shortTitle ?: "" })
        } else {
            val tags = arguments.getStringArrayList(INRoute.EXTRA_BOOK_MINORS)
            TagsAdapter(tags)
        }
        mRvTags.layoutManager = LinearLayoutManager(context)
        mRvTags.adapter = mAdapterTags
        mAdapterBooks.loadMoreEnd()
    }

    override fun setListener() {
        mAdapterTags.setOnItemClickListener { _, _, position ->
            if (mAdapterTags.selected != position) {
                mAdapterTags.setSelect(position)
                mPresenter?.getBooks(mAdapterTags.selected)
            }
        }

        mAdapterBooks.setOnLoadMoreListener({
            mPresenter?.getBooks(mAdapterTags.selected, true)
        }, mRvBooks)

        mAdapterBooks.setOnItemClickListener { _, _, position -> NovelRoute.toBookInfo(mAdapterBooks.getItem(position)?._id ?: "") }
    }

    override fun showBooks(data: List<Book>, isMore: Boolean) {
        if (isMore) {
            if (data.isEmpty()) {
                mAdapterBooks.loadMoreEnd()
            } else {
                mAdapterBooks.addData(data)
                mAdapterBooks.loadMoreComplete()
            }
        } else {
            mAdapterBooks.setNewData(data)
            if (isAdded) {
                if(activity is BooksByCatsActivity){
                    (activity as BooksByCatsActivity).loadSuccess()
                }else if(activity is BooksByRankActivity){
                    (activity as BooksByRankActivity).loadSuccess()
                }

            }
        }
    }

    override fun scrollToStart() {
        mRvBooks.scrollToPosition(0)
    }

    override fun loadMoreFail() {
        mAdapterBooks.loadMoreFail()
    }

    override fun refresh() {
        mPresenter?.getBooks(mAdapterTags.selected)
    }


}