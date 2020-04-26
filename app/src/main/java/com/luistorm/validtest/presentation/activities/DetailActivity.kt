package com.luistorm.validtest.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.luistorm.validtest.R
import com.luistorm.validtest.data.model.Artist
import com.luistorm.validtest.data.model.Track
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        initViews()
    }

    private fun initViews() {
        intent.extras?.let {
            it.getParcelable<Track>(TRACK)?.let { track ->
                Picasso.get().load(track.getLargeImage()).into(imageView)
                textViewName.text = track.name
                textViewListeners.text = getString(R.string.listeners, track.listeners.toString())
                textViewArtist.visibility = View.VISIBLE
                textViewArtist.text = getString(R.string.artist, track.artist.name)
                textViewRank.visibility = View.VISIBLE
                textViewRank.text = getString(R.string.rank, track.rank.rank.toString())
                textViewUrl.text = track.url
            } ?: run {
                it.getParcelable<Artist>(ARTIST)?.let { artist ->
                    Picasso.get().load(artist.getLargeImage()).into(imageView)
                    textViewName.text = artist.name
                    textViewListeners.text = getString(R.string.listeners, artist.listeners.toString())
                    textViewUrl.text = artist.url
                }
            }
        }
    }

    companion object {
        const val TRACK = "TRACK"
        const val ARTIST = "ARTIST"
    }
}
