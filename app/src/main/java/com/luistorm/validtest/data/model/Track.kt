package com.luistorm.validtest.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Track(
    @SerializedName("mbid") @Expose val mbid: String,
    @SerializedName("name") @Expose val name: String,
    @SerializedName("duration") @Expose val duration: Int,
    @SerializedName("listeners") @Expose val listeners: Long,
    @SerializedName("url") @Expose val url: String,
    @SerializedName("image") @Expose val image: List<ImageInfo>,
    @SerializedName("artist") @Expose val artist: Artist,
    @SerializedName("@attr") @Expose val rank: Rank
) {
    fun getSmallImage() = image!!.filter { it.size == "small" }[0].text
}