package com.vacral.rickmortiapi.domain.usecase

import com.vacral.rickmortiapi.domain.models.Info
import com.vacral.rickmortiapi.domain.repository.CharacterRepository
import com.vacral.rickmortiapi.network.model.AppError
import com.vacral.rickmortiapi.network.model.DataResult

class GetCharactersTotalInfoUseCase(
    private val repository: CharacterRepository
) {
    suspend operator fun invoke(): DataResult<Info, AppError> {
        return repository.getCharactersTotalInfo()
    }
}