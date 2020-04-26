package com.luistorm.validtest.data.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Rank(
    @SerializedName("rank") @Expose val rank: Long
): Parcelable