package com.oahgnez.kotlin.ngca.util

import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.Executors

/**
 * Created by oahgnez on 2018/5/22.
 * 常用rx线程调度，task在新线程中，ui线程中更细
 */
class ScheduleTransform<T> : ObservableTransformer<T, T> {
    companion object {
        private val threads by lazy{
            Executors.newCachedThreadPool()
        }
    }
    override fun apply(upstream: Observable<T>): ObservableSource<T> {
        return upstream.subscribeOn(Schedulers.from(threads))
                .observeOn(AndroidSchedulers.mainThread())
    }
}