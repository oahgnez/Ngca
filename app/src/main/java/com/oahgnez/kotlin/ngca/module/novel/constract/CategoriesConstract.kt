package com.oahgnez.kotlin.ngca.module.novel.constract

import com.oahgnez.kotlin.drlbbbie.base.MvpView
import com.oahgnez.kotlin.ngca.module.novel.model.CatsModel

/**
 * Created by oahgnez on 2018/5/22.
 */
interface CategoriesConstract{
    interface CategoriesView:MvpView{
        fun setMaleCats(cats:List<Cat>)
    }

    interface CategoriesPresenter{
        fun getCats()
        fun onGetCatsSuccess(data:CatsModel)
        fun onGetCatsFailure()
    }
}