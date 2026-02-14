package com.vacral.rickmortiapi.domain.usecase

import androidx.paging.PagingData
import com.vacral.rickmortiapi.domain.models.CharacterParams
import com.vacral.rickmortiapi.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import com.vacral.rickmortiapi.domain.models.Character

class GetCharactersPageSourceUseCase(
    private val repository: CharacterRepository
) {
    operator fun invoke(params: CharacterParams): Flow<PagingData<Character>> {
        return repository.getCharactersPageSource(params)
    }
}