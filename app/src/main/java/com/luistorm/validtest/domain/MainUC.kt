package com.luistorm.validtest.domain

import com.luistorm.validtest.data.model.TopArtistsResponse
import com.luistorm.validtest.data.repositories.GeoRepository
import io.reactivex.Observable


class MainUC(private val geoRepository: GeoRepository) {

    fun getTopArtists(country: String = "colombia", hasInternetConnection: Boolean): Observable<TopArtistsResponse> {
            return geoRepository.getRemoteTopArtists(country)
    }

}