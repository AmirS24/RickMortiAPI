package com.vacral.rickmortiapi.network.di

import android.util.Log
import com.vacral.rickmortiapi.network.util.configureCore
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import kotlinx.serialization.json.Json
import org.koin.core.qualifier.named
import org.koin.dsl.module

val networkModule = module {
    single(named("baseUrl")) { "https://rickandmortyapi.com/api/" }

    single { OkHttp.create() }

    single {
        Json {
            isLenient = true
            ignoreUnknownKeys = true
            prettyPrint = true
            encodeDefaults = false
            explicitNulls = false
        }
    }
    single<io.ktor.client.plugins.logging.Logger> {
        object : io.ktor.client.plugins.logging.Logger {
            override fun log(message: String) {
                Log.d("KTOR CLIENT", message)
            }
        }
    }

    single {
        HttpClient(engine = get()) {
            configureCore(
                json = get(),
                loggerDelegate = get(),
                baseUrl = get(named("baseUrl"))

            )
        }
    }
}