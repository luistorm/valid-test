package com.luistorm.validtest.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.luistorm.validtest.R
import com.luistorm.validtest.data.model.Artist
import com.luistorm.validtest.data.model.Track
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.artists_track_item.view.*

class TracksAdapter: RecyclerView.Adapter<TracksAdapter.TracksViewHolder>() {

    private val tracks: MutableList<Track> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = TracksViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.artists_track_item, parent, false))

    override fun getItemCount() = tracks.size

    override fun onBindViewHolder(holder: TracksViewHolder, position: Int) {
        holder.itemView.textViewName.text = tracks[position].name
        holder.itemView.textViewListeners.text = holder.itemView.context.getString(R.string.listeners, tracks[position].listeners.toString())
        holder.itemView.textViewArtist.visibility = View.VISIBLE
        holder.itemView.textViewArtist.text = holder.itemView.context.getString(R.string.artist, tracks[position].artist.name)
        Picasso.get().load(tracks[position].getSmallImage()).into(holder.itemView.imageView)
    }

    fun addItems(newTracks: List<Track>) {
        tracks.addAll(newTracks)
        notifyDataSetChanged()
    }

    inner class TracksViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}