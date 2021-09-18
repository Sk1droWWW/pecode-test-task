package com.example.pecodeTestTask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pecodeTestTask.databinding.ActivityMainBinding
import com.example.pecodeTestTask.item.OnItemFragmentListener

private const val NOTIFICATIONS_ID = "number"

class MainActivity : AppCompatActivity(), OnItemFragmentListener {

    private lateinit var activityMainBinding: ActivityMainBinding
    private var viewPagerAdapter: ViewPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        viewPagerAdapter = ViewPagerAdapter(
            supportFragmentManager,
            getFragmentCount(this)
        )
        activityMainBinding.viewPager.adapter = viewPagerAdapter
    }

    override fun onResume() {
        super.onResume()
        activityMainBinding.viewPager.currentItem = getCurrentItemNumber()
    }

    override fun onPause() {
        super.onPause()
        saveFragmentsCount(this, viewPagerAdapter!!.count)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        setIntent(intent)
    }

    override fun addFragment() {
        viewPagerAdapter?.addFragment(activityMainBinding.viewPager)
    }

    override fun removeFragment() {
        viewPagerAdapter?.removeFragment(activityMainBinding.viewPager)
    }

    private fun getCurrentItemNumber(): Int {
        return intent.getIntExtra(NOTIFICATIONS_ID, viewPagerAdapter!!.count) - 1
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
