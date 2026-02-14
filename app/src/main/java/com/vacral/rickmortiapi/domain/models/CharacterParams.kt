package com.vacral.rickmortiapi.domain.models

data class CharacterParams(
    val page: Int,
    val query: String?,
    val status: String?,
    val gender: String?,
    val species: String?,
    val type: String?,

) {
}