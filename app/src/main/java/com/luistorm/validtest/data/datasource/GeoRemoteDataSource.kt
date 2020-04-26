package com.luistorm.validtest.data.datasource

import com.luistorm.validtest.data.api.GeoApi

class GeoRemoteDataSource( private val geoApi: GeoApi) {
    fun getTopArtists(country: String, page: Int) = geoApi.getTopArtists(country, page)

    fun getTopTracks(country: String, page: Int) = geoApi.getTopTracks(country, page)
}