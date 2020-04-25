package com.luistorm.validtest.presentation

import android.app.Application
import com.luistorm.validtest.presentation.di.modules.apiModule
import com.luistorm.validtest.presentation.di.modules.repositoryModule
import com.luistorm.validtest.presentation.di.modules.useCasesModule
import com.luistorm.validtest.presentation.di.modules.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication: Application() {


    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(
                listOf(
                    apiModule,
                    viewModelModule,
                    repositoryModule,
                    useCasesModule
                )
            )
        }
    }
}