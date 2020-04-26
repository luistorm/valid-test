package com.luistorm.validtest.data.repositories

import com.luistorm.validtest.data.datasource.GeoLocalDataSource
import com.luistorm.validtest.data.datasource.GeoRemoteDataSource
import com.luistorm.validtest.data.model.Artist
import com.luistorm.validtest.data.model.Track

class GeoRepository(private val geoRemoteDataSource: GeoRemoteDataSource, private val geoLocalDataSource: GeoLocalDataSource) {
    fun getRemoteTopArtists(country: String, page: Int) = geoRemoteDataSource.getTopArtists(country, page)

    fun getRemoteTopTracks(country: String, page: Int) = geoRemoteDataSource.getTopTracks(country, page)

    fun insertArtist(artist: Artist) = geoLocalDataSource.insertArtist(artist)

    fun insertTrack(track: Track) = geoLocalDataSource.insertTrack(track)

    fun getLocalTopArtists() = geoLocalDataSource.getArtists()

    fun getLocalTopTracks() = geoLocalDataSource.getTracks()
}