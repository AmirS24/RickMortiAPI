package com.vacral.rickmortiapi.domain.repository

import androidx.paging.PagingData
import com.vacral.rickmortiapi.domain.models.Character
import com.vacral.rickmortiapi.domain.models.CharacterParams
import com.vacral.rickmortiapi.domain.models.Info
import com.vacral.rickmortiapi.network.model.AppError
import com.vacral.rickmortiapi.network.model.DataResult
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {

    fun  getCharacters(params: CharacterParams): Flow<PagingData<Character>>

    suspend fun getCharacteredById(characterId : Int): DataResult<Character, AppError>

    suspend fun getCharacterTotalInfo(): DataResult<Info, AppError>

}