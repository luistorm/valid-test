package com.luistorm.validtest

import com.luistorm.validtest.data.datasource.GeoLocalDataSource
import com.luistorm.validtest.data.local.GeoDBHelper
import com.luistorm.validtest.data.model.Artist
import com.luistorm.validtest.data.model.ImageInfo
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class GeoLocalDataSourceTest {

    @Mock
    private lateinit var geoDBHelper: GeoDBHelper

    private lateinit var geoLocalDataSource: GeoLocalDataSource

    @Before
    fun initTests() {
        MockitoAnnotations.initMocks(this)
        geoLocalDataSource = GeoLocalDataSource(geoDBHelper)
    }

    @Test
    fun insertArtistTest() {
        geoLocalDataSource.insertArtist(Artist("abc",
        "Luis",
        1000,
        "oncasfsvasduhfn",
        listOf(ImageInfo("lsdljkfnskd","small"), ImageInfo("lsdljkfnskd","large"))))

    }

}