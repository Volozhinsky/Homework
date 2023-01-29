package com.volozhinsky.homework.Lesson22.data.models

data class FilmInfoResponse(
    val name: String,
    val Rated: Double,
    val hasOscar: Boolean,
    val linkToPoster: String,
    val description: String
)