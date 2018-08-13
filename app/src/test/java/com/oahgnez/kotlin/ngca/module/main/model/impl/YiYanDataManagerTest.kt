package com.oahgnez.kotlin.ngca.module.main.model.impl

import com.oahgnez.kotlin.ngca.java.Types
import com.oahgnez.kotlin.ngca.module.main.model.data.YiYan
import io.reactivex.observers.DisposableObserver
import org.junit.Test

/**
 * Created by oahgnez on 2018/8/13.
 */
class YiYanDataManagerTest {
    @Test
    fun getYiYan() {
        YiYanDataManager.getYiYan("a").subscribeWith(object : DisposableObserver<YiYan>(){
            override fun onNext(t: YiYan) {
                System.out.print(t.hitokoto)
            }

            override fun onError(e: Throwable) {
                e.printStackTrace()
            }

            override fun onComplete() {

            }
        })
    }


}