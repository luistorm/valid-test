package com.luistorm.validtest.data.local

import android.provider.BaseColumns

object ArtistContract {
    object ArtistEntry : BaseColumns {
        const val TABLE_NAME = "artist"
        const val COLUMN_NAME_NAME = "name"
        const val COLUMN_NAME_LISTENERS = "listeners"
        const val COLUMN_NAME_IMAGE_SMALL = "image_small"
        const val COLUMN_NAME_IMAGE_LARGE = "image_large"
        const val COLUMN_NAME_URL = "url"
    }
}