package com.luistorm.validtest.data.repositories

import com.luistorm.validtest.data.datasource.GeoRemoteDataSource

class GeoRepository(private val geoRemoteDataSource: GeoRemoteDataSource) {
    fun getRemoteTopArtists(country: String, page: Int) = geoRemoteDataSource.getTopArtists(country, page)

    fun getRemoteTopTracks(country: String, page: Int) = geoRemoteDataSource.getTopTracks(country, page)
}