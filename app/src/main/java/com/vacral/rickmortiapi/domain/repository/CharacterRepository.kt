package com.vacral.rickmortiapi.domain.repository

import androidx.paging.PagingData
import com.vacral.rickmortiapi.domain.models.Character
import com.vacral.rickmortiapi.domain.models.CharacterParams
import com.vacral.rickmortiapi.domain.models.CharacterResponse
import com.vacral.rickmortiapi.domain.models.Info
import com.vacral.rickmortiapi.network.model.AppError
import com.vacral.rickmortiapi.network.model.DataResult
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {

    fun getCharactersPageSource(params: CharacterParams): Flow<PagingData<Character>>

    suspend fun getCharacters(params: CharacterParams): DataResult<CharacterResponse, AppError>

    suspend fun getCharacterById(characterId: Int): DataResult<Character, AppError>

    suspend fun getCharactersByIds(characterIds: List<Int>): DataResult<List<Character>, AppError>

    suspend fun getCharactersTotalInfo(): DataResult<Info, AppError>
}