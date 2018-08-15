package com.oahgnez.kotlin.ngca.presenter.novel

import com.oahgnez.kotlin.ngca.api.NovelApiBuilder
import com.oahgnez.kotlin.ngca.contract.novel.BooksByRankContract
import com.oahgnez.kotlin.ngca.model.data.RankGenderResults
import com.oahgnez.kotlin.ngca.base.MvpPresenter
import com.oahgnez.kotlin.ngca.util.ScheduleTransform
import io.reactivex.observers.DisposableObserver

/**
 * Created by oahgnez on 2018/7/6.
 */
class BooksByRankPresenter: MvpPresenter<BooksByRankContract.IView>(), BooksByRankContract.IPresenter {
    override fun getRankGenders() {
        addDisposable(NovelApiBuilder.api.getRankGenders()
                .compose(ScheduleTransform<RankGenderResults>())
                .subscribeWith(object :DisposableObserver<RankGenderResults>(){
                    override fun onNext(t: RankGenderResults) {
                        if(t.ok){
                            mView?.showInit(t)
                        }
                    }

                    override fun onComplete() {

                    }

                    override fun onError(e: Throwable) {

                    }

                }))
    }

}