package com.volozhinsky.homework.Lesson22.model.models

data class FilmInfo(
    val name: String,
    val Rated: Double,
    val hasOscar: Boolean,
    val linkToPoster: String,
    val description: String
)