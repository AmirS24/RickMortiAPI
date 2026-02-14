package com.vacral.rickmortiapi.domain.usecase

import com.vacral.rickmortiapi.domain.repository.CharacterRepository
import com.vacral.rickmortiapi.network.model.AppError
import com.vacral.rickmortiapi.network.model.DataResult
import com.vacral.rickmortiapi.domain.models.Character

class GetCharacterByIdUseCase(
    private val repository: CharacterRepository
) {
    suspend operator fun invoke(characterId: Int): DataResult<Character, AppError> {
        return repository.getCharacterById(characterId)
    }
}