package com.vacral.rickmortiapi.domain.models

data class CharacterParams(
    val query: String?,
    val status: String?,
    val gender: String?,
    val species: String?,
    val type: String?,

) {
}