package com.vacral.rickmortiapi.domain.models

data class CharacterResponse(
    val info: Info,
    val results: List<Character>
)