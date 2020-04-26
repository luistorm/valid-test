package com.luistorm.validtest.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.luistorm.validtest.R
import com.luistorm.validtest.data.model.Artist
import com.luistorm.validtest.presentation.extensions.setSafeOnClickListener
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.artists_track_item.view.*

class ArtistsAdapter(private val onArtistSelectedListener: (Artist) -> Unit): RecyclerView.Adapter<ArtistsAdapter.ArtistsViewHolder>() {

    private val artists: MutableList<Artist> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ArtistsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.artists_track_item, parent, false))

    override fun getItemCount() = artists.size

    override fun onBindViewHolder(holder: ArtistsViewHolder, position: Int) {
        holder.itemView.textViewName.text = artists[position].name
        holder.itemView.textViewListeners.text = holder.itemView.context.getString(R.string.listeners, artists[position].listeners.toString())
        Picasso.get().load(artists[position].getSmallImage()).into(holder.itemView.imageView)
        holder.itemView.itemContainer.setSafeOnClickListener { onArtistSelectedListener(artists[position]) }
    }

    fun addItems(newArtists: List<Artist>) {
        artists.addAll(newArtists)
        notifyDataSetChanged()
    }

    inner class ArtistsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}