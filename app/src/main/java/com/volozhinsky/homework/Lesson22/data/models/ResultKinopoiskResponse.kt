package com.volozhinsky.homework.Lesson22.data.models

import com.google.gson.annotations.SerializedName

data class ResultKinopoiskResponse(
    @SerializedName("docs") val docs: List<FilmInfoResponse>
)
