package com.luistorm.validtest.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Rank(
    @SerializedName("rank") @Expose val rank: Long
)