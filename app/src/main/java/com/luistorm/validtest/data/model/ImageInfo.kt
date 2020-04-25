package com.luistorm.validtest.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ImageInfo(
    @SerializedName("#text") @Expose val text: String,
    @SerializedName("size") @Expose val size: String
)