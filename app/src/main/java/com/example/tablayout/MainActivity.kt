package com.example.tablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tablayout.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    //список с фрагментами
    private val fragmentList = listOf(
        FragmentNumber1.newInstance(),
        FragmentNumber2.newInstance(),
        FragmentNumber3.newInstance()
    )
    //да лучше сделать массив, но мы ленивые жопы
    private val fragmentListTitles = listOf(
        "Item 0",
        "Item 1",
        "Item 2"
    )

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = ViewPagerAdapter(this, fragmentList)
        binding.viewPager2.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager2){
            //текст заполняется ЗДЕСЬ иначе будут пустые табы
            tab, pos -> tab.text = fragmentListTitles[pos]

        //обязательно attach
        }.attach()
        showToast("Hello World")
    }
}