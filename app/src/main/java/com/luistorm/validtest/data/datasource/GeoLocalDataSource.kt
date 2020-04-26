package com.luistorm.validtest.data.datasource

import android.content.ContentValues
import android.provider.BaseColumns
import com.luistorm.validtest.data.local.ArtistContract
import com.luistorm.validtest.data.local.GeoDBHelper
import com.luistorm.validtest.data.local.TrackContract
import com.luistorm.validtest.data.model.*
import io.reactivex.Observable

class GeoLocalDataSource(private val geoDBHelper: GeoDBHelper) {

    fun insertArtist(artist: Artist) {
        val db = geoDBHelper.writableDatabase
        val values = ContentValues().apply {
            put(ArtistContract.ArtistEntry.COLUMN_NAME_NAME, artist.name)
            put(ArtistContract.ArtistEntry.COLUMN_NAME_LISTENERS, artist.listeners)
            put(ArtistContract.ArtistEntry.COLUMN_NAME_IMAGE_SMALL, artist.getSmallImage())
            put(ArtistContract.ArtistEntry.COLUMN_NAME_IMAGE_LARGE, artist.getLargeImage())
            put(ArtistContract.ArtistEntry.COLUMN_NAME_URL, artist.url)
        }
        db?.insert(ArtistContract.ArtistEntry.TABLE_NAME, null, values)
    }

    fun insertTrack(track: Track) {
        val db = geoDBHelper.writableDatabase
        val values = ContentValues().apply {
            put(TrackContract.TrackEntry.COLUMN_NAME_NAME, track.name)
            put(TrackContract.TrackEntry.COLUMN_NAME_LISTENERS, track.listeners)
            put(TrackContract.TrackEntry.COLUMN_NAME_IMAGE_SMALL, track.getSmallImage())
            put(TrackContract.TrackEntry.COLUMN_NAME_IMAGE_LARGE, track.getLargeImage())
            put(TrackContract.TrackEntry.COLUMN_NAME_URL, track.url)
            put(TrackContract.TrackEntry.COLUMN_NAME_RANK, track.rank.rank)
            put(TrackContract.TrackEntry.COLUMN_NAME_ARTIST_NAME, track.artist.name)
        }
        db?.insert(TrackContract.TrackEntry.TABLE_NAME, null, values)
    }

    fun getArtists(): Observable<TopArtistsResponse> {
        val db = geoDBHelper.readableDatabase
        val projection = arrayOf(BaseColumns._ID,
            ArtistContract.ArtistEntry.COLUMN_NAME_NAME,
            ArtistContract.ArtistEntry.COLUMN_NAME_LISTENERS,
            ArtistContract.ArtistEntry.COLUMN_NAME_IMAGE_SMALL,
            ArtistContract.ArtistEntry.COLUMN_NAME_IMAGE_LARGE,
            ArtistContract.ArtistEntry.COLUMN_NAME_URL)
        val cursor = db.query(
            ArtistContract.ArtistEntry.TABLE_NAME,
            projection,
            null,
            null,
            null,
            null,
            null
        )
        val artists: MutableList<Artist> = mutableListOf()
        with(cursor) {
            while (moveToNext()) {
                artists.add(Artist("",
                    getString(getColumnIndexOrThrow(ArtistContract.ArtistEntry.COLUMN_NAME_NAME)),
                    getLong(getColumnIndexOrThrow(ArtistContract.ArtistEntry.COLUMN_NAME_LISTENERS)),
                    getString(getColumnIndexOrThrow(ArtistContract.ArtistEntry.COLUMN_NAME_URL)),
                listOf(ImageInfo(getString(getColumnIndexOrThrow(ArtistContract.ArtistEntry.COLUMN_NAME_IMAGE_SMALL)), "small"),
                    ImageInfo(getString(getColumnIndexOrThrow(ArtistContract.ArtistEntry.COLUMN_NAME_IMAGE_LARGE)), "large"))
                ))
            }
        }
        return Observable.just(TopArtistsResponse(TopArtists(artists, PageAttributes())))
    }

    fun getTracks(): Observable<TopTracksResponse> {
        val db = geoDBHelper.readableDatabase
        val projection = arrayOf(BaseColumns._ID,
            TrackContract.TrackEntry.COLUMN_NAME_NAME,
            TrackContract.TrackEntry.COLUMN_NAME_LISTENERS,
            TrackContract.TrackEntry.COLUMN_NAME_IMAGE_SMALL,
            TrackContract.TrackEntry.COLUMN_NAME_IMAGE_LARGE,
            TrackContract.TrackEntry.COLUMN_NAME_URL,
            TrackContract.TrackEntry.COLUMN_NAME_RANK,
            TrackContract.TrackEntry.COLUMN_NAME_ARTIST_NAME)
        val cursor = db.query(
            TrackContract.TrackEntry.TABLE_NAME,
            projection,
            null,
            null,
            null,
            null,
            null
        )
        val tracks: MutableList<Track> = mutableListOf()
        with(cursor) {
            while (moveToNext()) {
                tracks.add(
                    Track("",
                    getString(getColumnIndexOrThrow(TrackContract.TrackEntry.COLUMN_NAME_NAME)),0,
                    getLong(getColumnIndexOrThrow(TrackContract.TrackEntry.COLUMN_NAME_LISTENERS)),
                    getString(getColumnIndexOrThrow(TrackContract.TrackEntry.COLUMN_NAME_URL)),
                    listOf(ImageInfo(getString(getColumnIndexOrThrow(TrackContract.TrackEntry.COLUMN_NAME_IMAGE_SMALL)), "small"),
                        ImageInfo(getString(getColumnIndexOrThrow(TrackContract.TrackEntry.COLUMN_NAME_IMAGE_LARGE)), "large")),
                        Artist("", getString(getColumnIndexOrThrow(TrackContract.TrackEntry.COLUMN_NAME_ARTIST_NAME)),0,"",
                            listOf()),
                        Rank(getLong(getColumnIndexOrThrow(TrackContract.TrackEntry.COLUMN_NAME_RANK))))
                )
            }
        }
        return Observable.just(TopTracksResponse(TopTracks(tracks, PageAttributes())))
    }
}