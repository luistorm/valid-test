package com.luistorm.validtest.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.luistorm.validtest.data.model.Track
import com.luistorm.validtest.domain.TracksUC
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class TracksViewModel(private val tracksUC: TracksUC): ViewModel() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    private val _messagesLiveData = MutableLiveData<String>()
    val messagesLiveData: LiveData<String> = _messagesLiveData
    private val _tracksLiveData = MutableLiveData<List<Track>>()
    val tracksLiveData: LiveData<List<Track>> = _tracksLiveData
    private var pageNumber = 1

    fun getTopTracks(country: String, hasInternet: Boolean) {
        _messagesLiveData.value = "Loading tracks..."
        compositeDisposable.add(
            tracksUC.getTopTracks(country, hasInternet, pageNumber)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe ({
                    _tracksLiveData.value = it.tracks.track
                    if(hasInternet) tracksUC.insertTrack(it.tracks.track)
                    pageNumber++
                }, { _messagesLiveData.value = it.message })
        )
    }
}