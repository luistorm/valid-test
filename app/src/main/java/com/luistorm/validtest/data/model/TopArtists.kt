package com.luistorm.validtest.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TopArtists(
    @SerializedName("artist") @Expose val artist: List<Artist>,
    @SerializedName("@attr") @Expose val pageAttributes: PageAttributes
)