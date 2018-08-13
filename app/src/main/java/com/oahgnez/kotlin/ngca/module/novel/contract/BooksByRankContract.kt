package com.oahgnez.kotlin.ngca.module.novel.contract

import com.oahgnez.kotlin.ngca.base.MvpView
import com.oahgnez.kotlin.ngca.module.novel.data.model.RankGenderResults

/**
 * Created by oahgnez on 2018/7/6.
 */
interface BooksByRankContract{
    interface IView :MvpView{
        fun showInit(data: RankGenderResults)
    }

    interface IPresenter {
        fun getRankGenders()
    }
}