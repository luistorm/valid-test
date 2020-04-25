package com.luistorm.validtest.domain

import com.luistorm.validtest.data.repositories.GeoRepository


class MainUC(private val geoRepository: GeoRepository) {

    fun getTopAartists(country: String = "colombia", hasInternetConnection: Boolean) {
        if(hasInternetConnection) {
            geoRepository.getRemoteTopArtists(country)
        }
    }

}