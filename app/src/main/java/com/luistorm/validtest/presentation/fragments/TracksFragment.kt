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
import com.luistorm.validtest.data.model.Track
import com.luistorm.validtest.presentation.activities.DetailActivity
import com.luistorm.validtest.presentation.adapters.TracksAdapter
import com.luistorm.validtest.presentation.viewmodels.TracksViewModel
import kotlinx.android.synthetic.main.fragment_artists.*
import org.koin.android.viewmodel.ext.android.viewModel

class TracksFragment : Fragment() {

    private val tracksViewModel: TracksViewModel by viewModel()
    private lateinit var tracksAdapter: TracksAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.fragment_artists, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        setListenersAndObservers()
        tracksViewModel.getTopTracks("colombia", verifyAvailableNetwork())
    }

    private fun initViews() {
        tracksAdapter = TracksAdapter { goToDetail(it) }
        recyclerView.adapter = tracksAdapter
    }

    private fun verifyAvailableNetwork() : Boolean{
        val connectivityManager = activity!!.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return  networkInfo != null && networkInfo.isConnected
    }

    private fun setListenersAndObservers() {
        tracksViewModel.tracksLiveData.observe(this, Observer {
            tracksAdapter.addItems(it)
        })
        tracksViewModel.messagesLiveData.observe(this, Observer {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        })
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1)) {
                    tracksViewModel.getTopTracks("colombia", verifyAvailableNetwork())
                }
            }
        })
    }

    private fun goToDetail(track: Track) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra(DetailActivity.TRACK, track)
        startActivity(intent)
    }

    companion object {
        fun newInstance() = TracksFragment()
    }
}