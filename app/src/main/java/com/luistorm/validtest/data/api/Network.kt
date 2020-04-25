package com.luistorm.validtest.data.api

import retrofit2.Retrofit

class Network {

    fun getRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://ws.audioscrobbler.com")
            .build()
    }
}