package com.luistorm.validtest.data.api

import com.luistorm.validtest.data.model.TopArtistsResponse
import com.luistorm.validtest.data.model.TopTracksResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface GeoApi{

    @GET("/2.0/?method=geo.gettopartists&api_key=829751643419a7128b7ada50de590067&format=json")
    fun getTopArtists(@Query("country") country: String, @Query("page") page: Int): Observable<TopArtistsResponse>

    @GET("/2.0/?method=geo.gettoptracks&api_key=829751643419a7128b7ada50de590067&format=json")
    fun getTopTracks(@Query("country") country: String, @Query("page") page: Int): Observable<TopTracksResponse>

}