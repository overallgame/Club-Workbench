package com.example.clubworkbench

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.clubworkbench.Account.Account
import com.example.clubworkbench.Task.Task
import com.example.clubworkbench.Workbench.Workbench
import com.example.clubworkbench.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainActivityBinding

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainBottomNavigation.setOnItemSelectedListener { item ->
            val view = binding.mainBottomNavigation.findViewById<View>(item.itemId)
            if (view != null) {
                val animation = AnimationUtils.loadAnimation(this, R.animator.icon_click_animation)
                view.startAnimation(animation)
            }
            when (item.itemId) {
                R.id.task -> {
                    binding.viewPager.currentItem = 0
                    true
                }

                R.id.workbench -> {
                    binding.viewPager.currentItem = 1
                    true
                }

                R.id.mine -> {
                    binding.viewPager.currentItem = 2
                    true
                }

                else -> false
            }
        }

        val fragments: List<Fragment> = listOf(Task(),Workbench(),Account())
        val viewPagerAdapter = ViewPagerAdapter(lifecycle, supportFragmentManager, fragments)
        binding.viewPager.adapter = viewPagerAdapter
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.mainBottomNavigation.menu.findItem(when (position) {
                    0 -> R.id.task
                    1 -> R.id.workbench
                    2 -> R.id.mine
                    else -> throw IllegalStateException("Unknown position: $position")
                }).isChecked = true
            }
        })
    }
}