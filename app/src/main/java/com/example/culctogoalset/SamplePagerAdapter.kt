package com.example.culctogoalset

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class SamplePagerAdapter(fm: FragmentManager, private val fragmentList: List<Fragment>) :
    FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    // control fragments to show
    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    // size of contents to set viewPager
    override fun getCount(): Int {
        return fragmentList.size
    }
}