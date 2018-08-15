package com.oahgnez.kotlin.ngca.contract.novel

import com.oahgnez.kotlin.ngca.base.MvpView
import com.oahgnez.kotlin.ngca.model.data.RankGenderResults

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