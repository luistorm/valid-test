package com.luistorm.validtest.data.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ImageInfo(
    @SerializedName("#text") @Expose val text: String,
    @SerializedName("size") @Expose val size: String
): Parcelable
