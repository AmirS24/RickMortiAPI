package com.vacral.rickmortiapi.domain.usecase

import com.vacral.rickmortiapi.domain.models.CharacterParams
import com.vacral.rickmortiapi.domain.models.CharacterResponse
import com.vacral.rickmortiapi.domain.repository.CharacterRepository
import com.vacral.rickmortiapi.network.model.AppError
import com.vacral.rickmortiapi.network.model.DataResult


class GetCharactersUseCase(
    private val repository: CharacterRepository
) {
    suspend operator fun invoke(params: CharacterParams): DataResult<CharacterResponse, AppError> {
        return repository.getCharacters(params)
    }
}