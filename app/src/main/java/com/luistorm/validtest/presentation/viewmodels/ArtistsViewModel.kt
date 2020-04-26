package com.luistorm.validtest.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.luistorm.validtest.data.model.Artist
import com.luistorm.validtest.domain.ArtistsUC
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ArtistsViewModel(private val artistsUC: ArtistsUC): ViewModel() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    private val _messagesLiveData = MutableLiveData<String>()
    val messagesLiveData: LiveData<String> = _messagesLiveData
    private val _artistsLiveData = MutableLiveData<List<Artist>>()
    val artistsLiveData: LiveData<List<Artist>> = _artistsLiveData
    private var pageNumber = 1

    override fun onCleared() {
        compositeDisposable.clear()
    }

    fun getTopArtists(country: String, hasInternet: Boolean) {
        _messagesLiveData.value = "Loading artists..."
        compositeDisposable.add(
            artistsUC.getTopArtists(country, hasInternet, pageNumber)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnError { _messagesLiveData.value = it.message }
                .subscribe {
                    _artistsLiveData.value = it.topArtists.artist
                    pageNumber++
                }
        )
    }

}