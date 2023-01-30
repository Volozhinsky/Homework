package com.volozhinsky.homework.Lesson22.data.mappers

import com.volozhinsky.homework.Lesson22.data.models.FilmInfoResponse
import com.volozhinsky.homework.Lesson22.domain.models.FilmInfo

class FilmInfoMapper {
    operator fun invoke(response: FilmInfoResponse) = with(response) {
        FilmInfo(
            name = name ?: "",
            Rated = Rated ?: 0.0,
            hasOscar = hasOscar ?: false,
            linkToPoster = linkToPoster ?: "",
            description = description ?: ""
            )
    }
}
