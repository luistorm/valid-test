package com.luistorm.validtest.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PageAttributes(
    @SerializedName("country") @Expose val country: String = "",
    @SerializedName("page") @Expose val page: Int = 0,
    @SerializedName("perPage") @Expose val perPage: Int = 0,
    @SerializedName("totalPages") @Expose val totalPages: Int = 0
)