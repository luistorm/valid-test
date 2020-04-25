package com.luistorm.validtest.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PageAttributes(
    @SerializedName("country") @Expose val country: String,
    @SerializedName("page") @Expose val page: Int,
    @SerializedName("perPage") @Expose val perPage: Int,
    @SerializedName("totalPages") @Expose val totalPages: Int
)