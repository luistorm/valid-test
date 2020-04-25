package com.luistorm.validtest.presentation.adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.luistorm.validtest.R
import com.luistorm.validtest.presentation.fragments.ArtistsFragment
import com.luistorm.validtest.presentation.fragments.TracksFragment

class TopsPagerAdapter(fm: FragmentManager,
                              private val context: Context
): FragmentStatePagerAdapter(fm) {

    override fun getCount(): Int  = 2

    override fun getItem(i: Int): Fragment {
        return if(i == 0) {
            ArtistsFragment.newInstance()
        } else {
            TracksFragment.newInstance()
        }
    }

    override fun getPageTitle(position: Int): CharSequence {
        return if(position == 0) {
            context.getString(R.string.top_artist)
        } else {
            context.getString(R.string.top_tracks)
        }
    }
}