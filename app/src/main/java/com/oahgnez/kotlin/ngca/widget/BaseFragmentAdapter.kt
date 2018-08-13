package com.oahgnez.kotlin.ngca.widget

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by oahgnez on 2018/6/5.
 */
class BaseFragmentAdapter<T : Fragment>(manager: FragmentManager, var data: List<T>) : FragmentPagerAdapter(manager) {

    override fun getItem(position: Int): T {
        return data[position]
    }

    override fun getCount(): Int {
        return data.size
    }

    fun getFragment(index: Int): T {
        return data[index]
    }
}