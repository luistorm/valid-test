package com.luistorm.validtest.presentation.fragments

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.luistorm.validtest.R
import com.luistorm.validtest.data.model.Artist
import com.luistorm.validtest.data.model.Track
import com.luistorm.validtest.presentation.activities.DetailActivity
import com.luistorm.validtest.presentation.adapters.ArtistsAdapter
import com.luistorm.validtest.presentation.viewmodels.ArtistsViewModel
import kotlinx.android.synthetic.main.fragment_artists.*
import org.koin.android.viewmodel.ext.android.viewModel


class ArtistsFragment : Fragment() {

    private val artistsViewModel: ArtistsViewModel by viewModel()
    private lateinit var artistsAdapter: ArtistsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.fragment_artists, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        setListenersAndObservers()
        artistsViewModel.getTopArtists("colombia", verifyAvailableNetwork())
    }

    private fun initViews() {
        artistsAdapter = ArtistsAdapter { goToDetail(it) }
        recyclerView.adapter = artistsAdapter
    }

    private fun verifyAvailableNetwork() : Boolean{
        val connectivityManager = activity!!.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return  networkInfo != null && networkInfo.isConnected
    }

    private fun setListenersAndObservers() {
        artistsViewModel.artistsLiveData.observe(this, Observer {
            artistsAdapter.addItems(it)
        })
        artistsViewModel.messagesLiveData.observe(this, Observer {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        })
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1)) {
                    artistsViewModel.getTopArtists("colombia", verifyAvailableNetwork())
                }
            }
        })
    }

    private fun goToDetail(artist: Artist) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra(DetailActivity.ARTIST, artist)
        startActivity(intent)
    }

    companion object {
        fun newInstance() = ArtistsFragment()
    }
}
