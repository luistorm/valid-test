package com.luistorm.validtest.presentation.di.modules

import com.luistorm.validtest.data.api.GeoApi
import com.luistorm.validtest.data.api.Network
import com.luistorm.validtest.data.datasource.GeoLocalDataSource
import com.luistorm.validtest.data.datasource.GeoRemoteDataSource
import com.luistorm.validtest.data.local.GeoDBHelper
import com.luistorm.validtest.data.repositories.GeoRepository
import com.luistorm.validtest.domain.ArtistsUC
import com.luistorm.validtest.domain.TracksUC
import com.luistorm.validtest.presentation.MyApplication
import com.luistorm.validtest.presentation.viewmodels.ArtistsViewModel
import com.luistorm.validtest.presentation.viewmodels.TracksViewModel
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import org.koin.android.viewmodel.dsl.viewModel


val viewModelModule: Module = module {
    viewModel{ ArtistsViewModel(artistsUC = get()) }
    viewModel{ TracksViewModel(tracksUC = get()) }
}

val useCasesModule: Module = module {
    factory { ArtistsUC(geoRepository = get()) }
    factory { TracksUC(geoRepository = get()) }
}

val repositoryModule: Module = module {
    factory { GeoRepository(geoRemoteDataSource = get(), geoLocalDataSource = get()) }
}

val dataSourceModule: Module = module {
    factory { GeoRemoteDataSource(geoApi = get()) }
    factory { GeoLocalDataSource(geoDBHelper = geoDBHelper) }
}

val apiModule: Module = module {
    single(named("retrofitInstance")) { Network().getRetrofitInstance() }
    single { get<Retrofit>(named("retrofitInstance")).create(GeoApi::class.java) }
}

val geoDBHelper = GeoDBHelper(MyApplication.getApplicationContext())