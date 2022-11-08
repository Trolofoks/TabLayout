package com.example.tablayout

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

//наследование от StateAdapter и список с которогь будем брать фрагменты
class ViewPagerAdapter(fragAct: FragmentActivity, private val list: List<Fragment>): FragmentStateAdapter(fragAct) {
    override fun getItemCount(): Int {
        //просто размер списка, все просто
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        //фрагмент из списка по позиции
        return list[position]
    }
}