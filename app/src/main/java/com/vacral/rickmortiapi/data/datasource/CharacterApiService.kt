package com.vacral.rickmortiapi.data.datasource

import com.vacral.rickmortiapi.App
import com.vacral.rickmortiapi.data.mappers.toDomain
import com.vacral.rickmortiapi.data.model.CharacterRequest
import com.vacral.rickmortiapi.data.model.CharacterResponseDto
import com.vacral.rickmortiapi.domain.models.CharacterResponse
import com.vacral.rickmortiapi.network.model.AppError
import com.vacral.rickmortiapi.network.model.DataResult
import com.vacral.rickmortiapi.network.model.map
import com.vacral.rickmortiapi.network.util.safeCall
import com.vacral.rickmortiapi.network.util.safeGet
import io.ktor.client.HttpClient
import io.ktor.client.request.parameter
import io.ktor.http.parameters
import kotlinx.coroutines.Dispatchers
import okhttp3.Dispatcher

class CharacterApiService(
    private val client: HttpClient
) {

    suspend fun getCharacters(request: CharacterRequest): DataResult<CharacterResponse, AppError> =

        client.safeGet<CharacterResponseDto>(url = "character", dispatcher = Dispatchers.IO) {
            url.parameters.apply {
                append("page", request.page.toString())
                request.query?.let { append("name", it) }
                request.status?.let { append("status", it) }
                request.species?.let { append("species", it) }
                request.gender?.let { append("gender", it) }
                request.type?.let { append("type", it) }
            }
        }.map {
            it.toDomain()
        }


}