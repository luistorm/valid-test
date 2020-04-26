package com.luistorm.validtest.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TopTracksResponse(
    @SerializedName("tracks") @Expose val tracks: TopTracks
)