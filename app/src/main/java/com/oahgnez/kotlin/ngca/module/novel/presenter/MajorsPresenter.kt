package com.oahgnez.kotlin.ngca.module.novel.presenter

import com.oahgnez.kotlin.ngca.base.MvpPresenter
import com.oahgnez.kotlin.ngca.java.Types
import com.oahgnez.kotlin.ngca.module.novel.api.NovelApiBuilder
import com.oahgnez.kotlin.ngca.module.novel.contract.MajorsContract
import com.oahgnez.kotlin.ngca.module.novel.data.model.MajorResults
import com.oahgnez.kotlin.ngca.module.novel.data.model.MinorResults
import com.oahgnez.kotlin.ngca.route.NovelRoute
import com.oahgnez.kotlin.ngca.util.ScheduleTransform
import io.reactivex.observers.DisposableObserver

/**
 * Created by oahgnez on 2018/5/22.
 */
class MajorsPresenter : MvpPresenter<MajorsContract.IView>(), MajorsContract.IPresenter {

    var mMinorResults: MinorResults? = null

    override fun getCats() {
        addDisposable(NovelApiBuilder.api
                .getMajors()
                .compose(ScheduleTransform<MajorResults>())
                .subscribeWith(object : DisposableObserver<MajorResults>() {
                    override fun onComplete() {

                    }

                    override fun onNext(t: MajorResults) {
                        onGetCatsSuccess(t)
                    }

                    override fun onError(e: Throwable) {
                        onGetCatsFailure()
                    }

                }))
    }

    override fun onGetCatsSuccess(data: MajorResults) {
        if (data.ok) {
            mView?.setMaleCats(data.male)
            mView?.setFemaleCats(data.female)
            mView?.setPictureCats(data.picture)
            mView?.setPressCats(data.presses)
        }
    }

    override fun onGetCatsFailure() {

    }

    override fun getMinors() {
        addDisposable(NovelApiBuilder.api
                .getMinors()
                .compose(ScheduleTransform<MinorResults>())
                .subscribeWith(object : DisposableObserver<MinorResults>() {
                    override fun onNext(t: MinorResults) {
                        if (t.ok) {
                            mMinorResults = t
                        } else {

                        }
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }

                    override fun onComplete() {
                    }

                }))
    }

    override fun toBooks(gender: String, position: Int) {
        if (mMinorResults != null) {
            val catModel = when (gender) {
                Types.MALE -> mMinorResults!!.male[position]
                Types.FEMALE -> mMinorResults!!.female[position]
                Types.PICTURE -> mMinorResults!!.picture[position]
                Types.PRESS -> mMinorResults!!.press[position]
                else -> null
            }
            if (catModel != null) {
                NovelRoute.toBooksByCategory(gender, catModel.major, catModel.mins as ArrayList<String>)
            }
        } else {
            //
        }
    }
}