package com.vacral.rickmortiapi.data.di

import com.vacral.rickmortiapi.data.repository.RealCharacterRepository
import com.vacral.rickmortiapi.domain.repository.CharacterRepository
import org.koin.dsl.module

val dataModule = module {
    single<CharacterRepository> { RealCharacterRepository(get()) }
}