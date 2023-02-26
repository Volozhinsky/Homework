package com.volozhinsky.homework.Lesson22.data.models

import com.google.gson.annotations.SerializedName

data class FilmInfoResponse(
    @SerializedName("url") val name: String? = null,
    @SerializedName("url") val Rated: Double? = null,
    @SerializedName("url") val hasOscar: Boolean? = null,
    @SerializedName("url") val linkToPoster: String? = null,
    @SerializedName("url") val description: String? = null
){

    companion object {
        fun getDefault() = FilmInfoResponse()
    }
}