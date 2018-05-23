package com.oahgnez.kotlin.ngca.module.novel.presenter

import com.oahgnez.kotlin.drlbbbie.base.MvpPresenter
import com.oahgnez.kotlin.ngca.module.novel.api.NovelApiBuilder
import com.oahgnez.kotlin.ngca.module.novel.constract.CategoriesConstract
import com.oahgnez.kotlin.ngca.module.novel.model.CatsModel
import com.oahgnez.kotlin.ngca.util.ScheduleTransform
import io.reactivex.observers.DisposableObserver

/**
 * Created by oahgnez on 2018/5/22.
 */
class CategoriesPresenterImpl:MvpPresenter<CategoriesConstract.CategoriesView>(),CategoriesConstract.CategoriesPresenter{


    override fun getCats() {
        addDisposable(NovelApiBuilder.builder()
                .getAllCats()
                .compose(ScheduleTransform<CatsModel>())
                .subscribeWith(object :DisposableObserver<CatsModel>(){
                    override fun onComplete() {

                    }

                    override fun onNext(t: CatsModel) {
                        onGetCatsSuccess(t)
                    }

                    override fun onError(e: Throwable) {
                        onGetCatsFailure()
                    }

                }))
    }

    override fun onGetCatsSuccess(data:CatsModel) {
        mView.setMaleCats(data.male)
    }

    override fun onGetCatsFailure() {

    }
}