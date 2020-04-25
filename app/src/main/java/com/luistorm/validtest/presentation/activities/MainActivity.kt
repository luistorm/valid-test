package com.luistorm.validtest.presentation.activities

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.luistorm.validtest.R
import com.luistorm.validtest.presentation.adapters.TopsPagerAdapter
import com.luistorm.validtest.presentation.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //mainViewModel.getTopArtists("colombia", verifyAvailableNetwork())
        initViews()
    }

    fun verifyAvailableNetwork() : Boolean{
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return  networkInfo != null && networkInfo.isConnected
    }

    fun initViews() {
        viewPager.adapter = TopsPagerAdapter(supportFragmentManager, this)
    }
}
