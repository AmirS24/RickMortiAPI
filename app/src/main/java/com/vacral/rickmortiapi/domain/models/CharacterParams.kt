package com.vacral.rickmortiapi.domain.models

data class CharacterParams(
    val page: Int,
    val query: String? = null,
    val status: String? = null,
    val gender: String? = null,
    val species: String? = null,
    val type: String? = null,

) {
}