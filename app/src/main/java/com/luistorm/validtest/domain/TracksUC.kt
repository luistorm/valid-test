package com.luistorm.validtest.domain

import com.luistorm.validtest.data.model.TopTracksResponse
import com.luistorm.validtest.data.model.Track
import com.luistorm.validtest.data.repositories.GeoRepository
import io.reactivex.Observable

class TracksUC(private val geoRepository: GeoRepository) {
    fun getTopTracks(country: String = "colombia", hasInternetConnection: Boolean, page: Int): Observable<TopTracksResponse> {
        return if (hasInternetConnection) {
            geoRepository.getRemoteTopTracks(country, page)
        } else {
            geoRepository.getLocalTopTracks()
        }
    }

    fun insertTrack(tracks: List<Track>) {
        tracks.forEach { geoRepository.insertTrack(it) }
    }
}