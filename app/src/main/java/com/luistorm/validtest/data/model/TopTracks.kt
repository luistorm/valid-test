package com.luistorm.validtest.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TopTracks(
    @SerializedName("track") @Expose val track: List<Track>,
    @SerializedName("@attr") @Expose val pageAttributes: PageAttributes
)