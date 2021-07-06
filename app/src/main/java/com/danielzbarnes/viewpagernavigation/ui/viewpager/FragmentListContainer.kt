package com.danielzbarnes.viewpagernavigation.ui.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.danielzbarnes.viewpagernavigation.R
import com.danielzbarnes.viewpagernavigation.ui.gallery.GalleryFragment
import com.danielzbarnes.viewpagernavigation.ui.home.HomeFragment
import com.danielzbarnes.viewpagernavigation.ui.slideshow.SlideshowFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

private const val TAB_NUM = 3

class FragmentListContainer: Fragment() {

    private val tabNames = arrayListOf("Home", "Gallery", "Slideshow")

    private lateinit var tablayout: TabLayout
    private lateinit var viewpager: ViewPager2
    private lateinit var pagerAdapter: MyPagerAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_list_container, container, false)

        tablayout = view.findViewById(R.id.tab_layout)
        viewpager =  view.findViewById(R.id.viewpager)

        pagerAdapter = MyPagerAdapter(requireActivity())
        viewpager.adapter = pagerAdapter
        viewpager.isUserInputEnabled = false // setting to allow the user to swipe between pages

        // links the tablayout to the viewpager
        TabLayoutMediator(tablayout, viewpager){
            tab,pos -> tab.text = tabNames[pos]
        }.attach()

        tablayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewpager.setCurrentItem(tab!!.position, false)  // setting false makes the pages jump rather than slide
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) { }
            override fun onTabReselected(tab: TabLayout.Tab?) { }
        })

        return view
    }

    private class MyPagerAdapter(frag: FragmentActivity): FragmentStateAdapter(frag){

        override fun createFragment(position: Int): Fragment {
            return when (position){
                0 -> HomeFragment.newInstance()
                1 -> GalleryFragment.newInstance()
                2 -> SlideshowFragment.newInstance()
                else -> HomeFragment.newInstance()
            }
        }

        override fun getItemCount(): Int = TAB_NUM
    }

}