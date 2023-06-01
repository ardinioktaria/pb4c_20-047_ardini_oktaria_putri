package com.example.tugaspratikum6

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    val homeFragment = HomeFragment()
                    openFragment(homeFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_save -> {
                    val saveFragment = FakultasFragment()
                    openFragment(saveFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_history -> {
                    val historyFragment = TentangFragment()
                    openFragment(historyFragment)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    private fun openFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_container, fragment)
            .commit()
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)


        // Set NoteFragment as the initial fragment
        val homeFragment = HomeFragment()
        openFragment(homeFragment)
    }
}