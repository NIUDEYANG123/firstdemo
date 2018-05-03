package com.chinazyjr.githubapplication.adapater

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class TabAdapter(var fm: FragmentManager, var mDatas: List<Fragment>, var titles: List<String>) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return mDatas[position]
    }

    override fun getCount(): Int {
        return mDatas.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return titles[position]
    }
}