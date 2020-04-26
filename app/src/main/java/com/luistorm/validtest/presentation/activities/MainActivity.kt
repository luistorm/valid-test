package com.luistorm.validtest.presentation.activities

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.luistorm.validtest.R
import com.luistorm.validtest.presentation.adapters.TopsPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    fun initViews() {
        viewPager.adapter = TopsPagerAdapter(supportFragmentManager, this)
    }
}
