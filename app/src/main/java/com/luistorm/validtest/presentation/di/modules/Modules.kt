package com.luistorm.validtest.presentation.di.modules

import com.luistorm.validtest.data.api.GeoApi
import com.luistorm.validtest.data.api.Network
import com.luistorm.validtest.data.datasource.GeoRemoteDataSource
import com.luistorm.validtest.data.repositories.GeoRepository
import com.luistorm.validtest.domain.MainUC
import com.luistorm.validtest.presentation.viewmodels.MainViewModel
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import org.koin.android.viewmodel.dsl.viewModel


val viewModelModule: Module = module {
    viewModel{ MainViewModel(mainUC = get()) }
}

val useCasesModule: Module = module {
    factory { MainUC(geoRepository = get()) }
}

val repositoryModule: Module = module {
    factory { GeoRepository(geoRemoteDataSource = get()) }
}

val dataSourceModule: Module = module {
    factory { GeoRemoteDataSource(geoApi = get()) }
}

val apiModule: Module = module {
    single(named("retrofitInstance")) { Network().getRetrofitInstance() }
    single { get<Retrofit>(named("retrofit")).create(GeoApi::class.java) }
}