package com.luistorm.validtest.domain

import com.luistorm.validtest.data.model.Artist
import com.luistorm.validtest.data.model.TopArtistsResponse
import com.luistorm.validtest.data.model.TopTracksResponse
import com.luistorm.validtest.data.repositories.GeoRepository
import io.reactivex.Observable


class ArtistsUC(private val geoRepository: GeoRepository) {

    fun getTopArtists(country: String = "colombia", hasInternetConnection: Boolean, page: Int): Observable<TopArtistsResponse> {
        return if(hasInternetConnection) {
            geoRepository.getRemoteTopArtists(country, page)
        } else {
            geoRepository.getLocalTopArtists()
        }
    }

    fun insertArtists(artists: List<Artist>) {
        artists.forEach { geoRepository.insertArtist(it) }
    }

}