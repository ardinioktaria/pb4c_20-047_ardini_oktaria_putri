package com.example.tugaspraktikum5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class Adapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = FeedFragment()
            1 -> fragment = HistoryFragment()
            2 -> fragment = SearchFragment()
        }
        return fragment as Fragment
    }

    override fun getItemCount(): Int {
        return 3
    }


}