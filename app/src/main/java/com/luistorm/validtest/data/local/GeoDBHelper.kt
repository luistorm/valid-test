package com.luistorm.validtest.data.local

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns

class GeoDBHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    private val SQL_CREATE_ENTRIES_ARTIST =
        "CREATE TABLE ${ArtistContract.ArtistEntry.TABLE_NAME} (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                "${ArtistContract.ArtistEntry.COLUMN_NAME_NAME} TEXT," +
                "${ArtistContract.ArtistEntry.COLUMN_NAME_LISTENERS} INTEGER," +
                "${ArtistContract.ArtistEntry.COLUMN_NAME_IMAGE_SMALL} TEXT," +
                "${ArtistContract.ArtistEntry.COLUMN_NAME_IMAGE_LARGE} TEXT," +
                "${ArtistContract.ArtistEntry.COLUMN_NAME_URL} TEXT)"

    private val SQL_DELETE_ENTRIES_ARTIST = "DROP TABLE IF EXISTS ${ArtistContract.ArtistEntry.TABLE_NAME}"

    private val SQL_CREATE_ENTRIES_TRACK =
        "CREATE TABLE ${TrackContract.TrackEntry.TABLE_NAME} (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                "${TrackContract.TrackEntry.COLUMN_NAME_NAME} TEXT," +
                "${TrackContract.TrackEntry.COLUMN_NAME_LISTENERS} INTEGER," +
                "${TrackContract.TrackEntry.COLUMN_NAME_IMAGE_SMALL} TEXT," +
                "${TrackContract.TrackEntry.COLUMN_NAME_IMAGE_LARGE} TEXT," +
                "${TrackContract.TrackEntry.COLUMN_NAME_URL} TEXT," +
                "${TrackContract.TrackEntry.COLUMN_NAME_RANK} INTEGER," +
                "${TrackContract.TrackEntry.COLUMN_NAME_ARTIST_NAME} TEXT)"

    private val SQL_DELETE_ENTRIES_TRACK = "DROP TABLE IF EXISTS ${TrackContract.TrackEntry.TABLE_NAME}"

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(SQL_CREATE_ENTRIES_ARTIST)
        db?.execSQL(SQL_CREATE_ENTRIES_TRACK)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(SQL_DELETE_ENTRIES_ARTIST)
        db?.execSQL(SQL_DELETE_ENTRIES_TRACK)
        onCreate(db)
    }

    override fun onDowngrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }

    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "Geo.db"
    }
}