package com.vacral.rickmortiapi.domain.di

import com.vacral.rickmortiapi.domain.usecase.GetCharacterByIdUseCase
import com.vacral.rickmortiapi.domain.usecase.GetCharactersByIdsUseCase
import com.vacral.rickmortiapi.domain.usecase.GetCharactersPageSourceUseCase
import com.vacral.rickmortiapi.domain.usecase.GetCharactersTotalInfoUseCase
import com.vacral.rickmortiapi.domain.usecase.GetCharactersUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule = module {
    factoryOf(::GetCharactersUseCase)
    factoryOf(::GetCharacterByIdUseCase)
    factoryOf(::GetCharactersByIdsUseCase)
    factoryOf(::GetCharactersPageSourceUseCase)
    factoryOf(::GetCharactersTotalInfoUseCase)
}