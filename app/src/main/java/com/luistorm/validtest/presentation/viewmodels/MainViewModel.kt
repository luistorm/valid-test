package com.luistorm.validtest.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.luistorm.validtest.domain.MainUC
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val mainUC: MainUC): ViewModel() {

    fun getTopArtists(country: String, hasInternet: Boolean) {
        mainUC.getTopArtists(country, hasInternet)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnError {
                val x = 0
            }
            .subscribe {
                val y = 1
            }
    }

}