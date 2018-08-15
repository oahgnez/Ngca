package com.oahgnez.kotlin.ngca.contract

import com.oahgnez.kotlin.ngca.base.MvpView
import com.oahgnez.kotlin.ngca.model.data.PixivImage
import com.oahgnez.kotlin.ngca.model.data.YiYan

/**
 * Created by oahgnez on 2018/8/7.
 */
interface LoadingContract{
    interface IView:MvpView{
        fun showWord(data: YiYan)
        fun showImage(t: PixivImage)
    }

    interface IPresenter{
        fun getImage()
        fun getWord()
    }


}