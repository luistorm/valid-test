package com.luistorm.validtest.data.datasource

import com.luistorm.validtest.data.api.GeoApi

class GeoRemoteDataSource( private val geoApi: GeoApi) {
    fun getTopArtists(country: String) = geoApi.getTopArtists(country)
}