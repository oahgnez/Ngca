package com.oahgnez.kotlin.ngca.contract.novel

import com.oahgnez.kotlin.ngca.base.MvpView
import com.oahgnez.kotlin.ngca.java.Types
import com.oahgnez.kotlin.ngca.model.data.Major
import com.oahgnez.kotlin.ngca.model.data.MajorResults

/**
 * Created by oahgnez on 2018/5/22.
 */
interface MajorsContract {
    interface IView :MvpView{
        fun setMaleCats(majors: List<Major>)
        fun setFemaleCats(majors: List<Major>)
        fun setPictureCats(majors: List<Major>)
        fun setPressCats(majors: List<Major>)
    }

    interface IPresenter {
        fun getCats()
        fun onGetCatsSuccess(data: MajorResults)
        fun onGetCatsFailure()
        fun getMinors()
        fun toBooks(@Types.GenderType gender:String, position:Int)
    }


}