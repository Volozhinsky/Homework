package com.volozhinsky.homework.Lesson22.data.models

data class FilmInfoResponse(
    val name: String? = null,
    val Rated: Double? = null,
    val hasOscar: Boolean? = null,
    val linkToPoster: String? = null,
    val description: String? = null
){

    companion object {
        fun getDefault() = FilmInfoResponse()
    }
}