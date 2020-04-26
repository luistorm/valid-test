package com.luistorm.validtest.data.local

import android.provider.BaseColumns

object TrackContract {
    object TrackEntry : BaseColumns {
        const val TABLE_NAME = "track"
        const val COLUMN_NAME_NAME = "name"
        const val COLUMN_NAME_LISTENERS = "listeners"
        const val COLUMN_NAME_IMAGE_SMALL = "image_small"
        const val COLUMN_NAME_IMAGE_LARGE = "image_large"
        const val COLUMN_NAME_URL = "url"
        const val COLUMN_NAME_RANK = "rank"
        const val COLUMN_NAME_ARTIST_NAME = "artist_name"
    }
}