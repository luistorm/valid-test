package com.luistorm.validtest.data.repositories

import com.luistorm.validtest.data.datasource.GeoRemoteDataSource

class GeoRepository(private val geoRemoteDataSource: GeoRemoteDataSource) {
    fun getRemoteTopArtists(country: String) = geoRemoteDataSource.getTopArtists(country)
}