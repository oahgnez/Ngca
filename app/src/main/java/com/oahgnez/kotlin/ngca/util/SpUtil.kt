package com.oahgnez.kotlin.ngca.util

import android.app.Activity
import com.oahgnez.kotlin.ngca.app.NgcaApp

/**
 * Created by oahgnez on 2018/7/6.
 */
class SpUtil(file:String){
    private val mSp = NgcaApp.instance.getSharedPreferences(file, Activity.MODE_PRIVATE)
    fun putString(key:String,data:String){
        mSp.edit().putString(key,data).commit()
    }

    fun put(map:HashMap<String,String>){
        val edit =mSp.edit()
        map.map { edit.putString(it.key,it.value) }
        edit.commit()
    }
}