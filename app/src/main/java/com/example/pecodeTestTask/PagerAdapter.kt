package com.example.pecodeTestTask

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.pecodeTestTask.item.ItemFragment
import java.util.ArrayList

class ViewPagerAdapter(fm: FragmentManager, count: Int) :
    FragmentStatePagerAdapter(fm) {
    private val list: MutableList<Int>

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(i: Int): Fragment {
        return ItemFragment.newInstance(list[i], list.size)
    }

    override fun getItemPosition(`object`: Any): Int {
        val index = list.indexOf(`object`)
        return if (index == -1) POSITION_NONE else index
    }

    fun addFragment(viewPager: ViewPager) {
        list.add(list.size + 1)
        this.notifyDataSetChanged()
        viewPager.currentItem = list.size - 1
    }

    fun removeFragment(viewPager: ViewPager) {
        list.removeAt(list.size - 1)
        this.notifyDataSetChanged()
        viewPager.currentItem = list.size - 1
    }

    init {
        list = ArrayList()
        for (i in 0 until count) {
            list.add(i + 1)
        }
    }
}