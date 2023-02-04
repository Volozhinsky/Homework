package com.volozhinsky.homework.Lesson22.domain.models

data class FilmInfo(
    val name: String,
    val Rated: Double,
    val hasOscar: Boolean,
    val linkToPoster: String,
    val description: String
)