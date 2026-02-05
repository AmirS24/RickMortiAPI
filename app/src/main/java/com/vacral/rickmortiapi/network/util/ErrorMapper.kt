package com.vacral.rickmortiapi.network.util

import androidx.compose.ui.input.pointer.RequestDisallowInterceptTouchEvent
import com.vacral.rickmortiapi.network.model.AppError
import io.ktor.client.call.NoTransformationFoundException
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.statement.bodyAsText
import io.ktor.http.vary
import io.ktor.serialization.JsonConvertException
import kotlinx.io.IOException
import kotlinx.serialization.SerializationException

data class ApiErrorResponseDto(
    val message: String? = null,
    val detail: String? = null
){
    val userMassege : String?
        get() = message
            ?: detail
            ?: "unknow json key"
}

suspend fun mapExceptionToAppError(e: Exception) : AppError{
    return when(e){
        is ClientRequestException ->{
            val status = e.response.status.value
            var message: String? = null

            try {
                val dto = e.response.body<ApiErrorResponseDto>()
                message = dto.userMassege
            }catch (_: Exception){
                message = try {
                    e.response.bodyAsText()
                }catch (_: Exception){
                    null
                }
            }
            when (status) {
                400 -> AppError.Api.BadRequest(message ?: "Ошибка 400, Проверьте правильность ввода данных")
                401 -> AppError.Api.Unauthorized(message ?: "Пользователь не авторизован")
                403 -> AppError.Api.Forbidden(message ?: "Для этого пользователя запрос запрещен")
                404 -> AppError.Api.NotFound(message ?: "Не найден запрос")
                409 -> AppError.Api.Conflict(message ?: "Конфликт")
                422 -> AppError.Api.BadRequest(message ?: "Плохой запрос,  Проверьте правильность ввода данных")
                429 -> AppError.Api.TooManyRequests(message ?: "Слишком много запросов")
                else -> AppError.Api.BadRequest("Error $status: $message")
            }
        }
        is ServerResponseException -> {
            val status = e.response.status.value
            if(status == 503) AppError.Network.ServerUnavailable
            else AppError.Api.ServerError(status, e.message)
        }
        is RedirectResponseException -> AppError.Network.Unknown("Redirect error: ${e.message}")
        is JsonConvertException,
        is NoTransformationFoundException,
        is SerializationException -> AppError.Network.Serialization

        is IOException -> AppError.Network.NoInternet

        else -> AppError.Unknown(e.message)
    }
}