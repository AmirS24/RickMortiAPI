package com.vacral.rickmortiapi

import android.app.Application
import com.vacral.rickmortiapi.data.di.dataModule
import com.vacral.rickmortiapi.domain.di.domainModule
import com.vacral.rickmortiapi.network.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level


class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            androidLogger(level = Level.DEBUG)

            modules(
                dataModule, domainModule, networkModule
            )
        }
    }
}