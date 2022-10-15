package com.lmar.splashscreen

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.lmar.splashscreen.fragments.HomeFragment
import com.lmar.splashscreen.fragments.LikeFragment
import com.lmar.splashscreen.fragments.SearchFragment
import com.lmar.splashscreen.fragments.ShopFragment


class MainActivity : AppCompatActivity() {

    private lateinit var navigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //this line hide statusbar
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        navigationView = findViewById(R.id.bottom_navigation)
        supportFragmentManager.beginTransaction().replace(R.id.body_container, HomeFragment())
            .commit()
        navigationView.selectedItemId = R.id.nav_home

        navigationView.setOnNavigationItemSelectedListener { item ->
            var fragment: Fragment? = null
            when (item.itemId) {
                R.id.nav_home -> fragment = HomeFragment()
                R.id.nav_search -> fragment = SearchFragment()
                R.id.nav_like -> fragment = LikeFragment()
                R.id.nav_shop -> fragment = ShopFragment()
            }
            supportFragmentManager.beginTransaction().replace(R.id.body_container, fragment!!)
                .commit()
            true
        }
    }
}