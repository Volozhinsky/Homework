package com.volozhinsky.homework.Lesson22.ui.mappers

import com.volozhinsky.homework.Lesson22.domain.models.FilmInfo
import com.volozhinsky.homework.Lesson22.ui.models.FilmInfoUI

class FilmInfoMapperUI {
    operator fun invoke(response: FilmInfo) = with(response) {
        FilmInfoUI(
            name = name,
            Rated = Rated,
            hasOscar = hasOscar,
            linkToPoster = linkToPoster,
            description = description
        )
    }
}