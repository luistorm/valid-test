package com.luistorm.validtest.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Artist(
    @SerializedName("mbid") @Expose val mbid: String,
    @SerializedName("name") @Expose val name: String,
    @SerializedName("listeners") @Expose val listeners: Long?,
    @SerializedName("url") @Expose val url: String,
    @SerializedName("image") @Expose val image: List<ImageInfo>
)