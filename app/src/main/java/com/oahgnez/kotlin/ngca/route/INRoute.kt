package com.oahgnez.kotlin.ngca.route

import com.oahgnez.kotlin.ngca.java.Types

/**
 * Created by oahgnez on 2018/6/4.
 * 页面路由，声明路由路径与参数名
 */
interface INRoute {
    companion object {
        const val ROUTE_MAJORS = "/novel/majors"

        const val ROUTE_BOOKS_BY_CATS = "/novel/booksByCats"
        const val ROUTE_BOOKS_BY_RANK = "/novel/booksByRank"

        const val EXTRA_GENDER = "extra_gender"
        const val EXTRA_MAJOR = "extra_major"
        const val EXTRA_CAT = "extra_cat"
        const val EXTRA_BOOK_MINORS = "extra_minors_of_major"

        const val ROUTE_BOOK_INFO = "/novel/bookinfo"
        const val EXTRA_BOOK_ID = "extra_book_id"
        const val EXTRA_RANK_ID = "extra_rank_id"
    }

    /** 大类*/
    fun toMajors()

    /**
     * 跳转到分类列表*/
    fun toBooksByCategory(@Types.GenderType gender: String, major: String, minors: ArrayList<String>)

    /** 跳转到排行榜*/
    fun toBooksByRank()

    /** 跳转到书籍详情*/
    fun toBookInfo(id: String)
}