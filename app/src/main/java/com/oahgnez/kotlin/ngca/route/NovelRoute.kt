package com.oahgnez.kotlin.ngca.route

import com.alibaba.android.arouter.launcher.ARouter

/**
 * Created by oahgnez on 2018/6/4.
 */
object NovelRoute : INRoute {
    override fun toBooksByCategory(gender: String, major: String, minors:ArrayList<String>) {
        ARouter.getInstance()
                .build(INRoute.ROUTE_BOOKS_BY_CATS)
                .withString(INRoute.EXTRA_GENDER, gender)
                .withString(INRoute.EXTRA_MAJOR, major)
                .withStringArrayList(INRoute.EXTRA_BOOK_MINORS,minors)
                .navigation()
    }


    override fun toMajors() {
        ARouter.getInstance()
                .build(INRoute.ROUTE_MAJORS)
                .navigation()
    }


    override fun toBookInfo(id:String) {
        ARouter.getInstance()
                .build(INRoute.ROUTE_BOOK_INFO)
                .withString(INRoute.EXTRA_BOOK_ID,id)
                .navigation()
    }

    override fun toBooksByRank() {
        ARouter.getInstance()
                .build(INRoute.ROUTE_BOOKS_BY_RANK)
                .navigation()
    }



}