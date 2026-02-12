package com.vacral.rickmortiapi.data.model

data class CharacterRequest(
    val page: Int,
    val query: String?,
    val status: String?,
    val gender: String?,
    val species: String?,
    val type: String?,

) {
}