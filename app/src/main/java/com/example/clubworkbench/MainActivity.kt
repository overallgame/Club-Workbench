package com.example.clubworkbench

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
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
                val animation = AnimationUtils.loadAnimation(this,R.animator.icon_click_animation)
                view.startAnimation(animation)
            }
            when (item.itemId) {
                R.id.task -> {
                    binding.mainPager.currentItem = 0
                    true
                }

                R.id.workbench -> {
                    binding.mainPager.currentItem = 1
                    true
                }

                R.id.mine -> {
                    binding.mainPager.currentItem = 2
                    true
                }

                else -> false
            }
        }

        val fragments: List<Fragment> = listOf()
        val viewPagerAdapter = ViewPagerAdapter(lifecycle, supportFragmentManager, fragments)
        binding.mainPager.adapter = viewPagerAdapter
        binding.mainPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
            }
        })
    }
}