package com.volozhinsky.homework.Lesson22.ui.films_low_rated

import com.volozhinsky.homework.Lesson22.ui.models.FilmInfoUI

interface LowRatedFilmInfoView {

    fun setViewAdapterData(listFilmInfoResponse: List<FilmInfoUI>)
}