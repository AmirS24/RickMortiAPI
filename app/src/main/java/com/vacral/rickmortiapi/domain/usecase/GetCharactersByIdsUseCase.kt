package com.vacral.rickmortiapi.domain.usecase

import com.vacral.rickmortiapi.domain.repository.CharacterRepository
import com.vacral.rickmortiapi.network.model.AppError
import com.vacral.rickmortiapi.network.model.DataResult
import com.vacral.rickmortiapi.domain.models.Character


class GetCharactersByIdsUseCase {
    class GetCharactersByIdsUseCase(
        private val repository: CharacterRepository
    ) {
        suspend operator fun invoke(charactersIds: List<Int>): DataResult<List<Character>, AppError> {
            return repository.getCharactersByIds(charactersIds)
        }
    }
}