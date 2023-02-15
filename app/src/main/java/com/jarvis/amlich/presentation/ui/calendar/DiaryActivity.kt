package com.jarvis.amlich.presentation.ui.calendar

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.jarvis.amlich.base.BaseActivity
import com.jarvis.amlich.databinding.ActivityCalendarBinding
import com.jarvis.amlich.presentation.ui.calendar.adapter.SlideAdapter

class DiaryActivity : BaseActivity<ActivityCalendarBinding>(ActivityCalendarBinding::inflate) {
    var tabIndex = 0
    private var tabWeek: TabLayout.Tab? = null
    private var tabMonth: TabLayout.Tab? = null
    private var tabYear: TabLayout.Tab? = null
    private var fragmentList: MutableList<Fragment>? = null


    override fun initData() {
        super.initData()

        setupViewPager()
        setOnClickListener()
    }

    private fun setupViewPager() {
        val diaryWeekFragment = DiaryWeekFragment()
        val diaryMonthFragment = DiaryMonthFragment()
        val diaryYearFragment = DiaryYearFragment()
        fragmentList = ArrayList()
        fragmentList?.add(diaryWeekFragment)
        fragmentList?.add(diaryMonthFragment)
        fragmentList?.add(diaryYearFragment)
        viewBD.viewPager.offscreenPageLimit = 3
        val adapter = SlideAdapter(
            supportFragmentManager,
            FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        )
        adapter.addData(fragmentList)
        viewBD.viewPager.adapter = adapter
        tabWeek = viewBD.viewTab.getTabAt(FRAGMENT_WEEK)
        tabMonth = viewBD.viewTab.getTabAt(FRAGMENT_MONTH)
        tabYear = viewBD.viewTab.getTabAt(FRAGMENT_YEAR)
        viewBD.viewPager.currentItem = tabIndex
        setupTabLayout()
    }

    fun setupTabLayout() {
        when (tabIndex) {
            FRAGMENT_YEAR -> {
                viewBD.viewTab.selectTab(tabYear)
            }
            FRAGMENT_MONTH -> {
                viewBD.viewTab.selectTab(tabMonth)
            }
            else -> {
                viewBD.viewTab.selectTab(tabWeek)
            }
        }
    }

    private fun setOnClickListener() {
        viewBD.viewTab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewBD.viewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
        viewBD.viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                tabIndex = position
                val baseFragment: Fragment = fragmentList!![position]
                setupTabLayout()
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
    }

    companion object {
        const val FRAGMENT_WEEK = 0
        const val FRAGMENT_MONTH = 1
        const val FRAGMENT_YEAR = 2
    }
}