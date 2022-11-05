package com.example.tablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tablayout.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    //список с фрагментами
    private val fragmentList = listOf(
        FragmentNumber1.newInstance(),
        FragmentNumber2.newInstance(),
        FragmentNumber3.newInstance()
    )
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //основная строчка для tabLayout
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            //три функции снизу имплементируются от обджекта
            override fun onTabSelected(tab: TabLayout.Tab?) {
                supportFragmentManager
                    .beginTransaction()
                    .replace(binding.placeHolder.id, fragmentList[tab?.position!!])
                    .commit()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                //эти временно можно игнорить
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                //эти временно можно игнорить
            }

        })
    }
}