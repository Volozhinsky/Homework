package com.volozhinsky.homework.Lesson22.ui.films_full

import com.volozhinsky.homework.Lesson22.ui.models.FilmInfoUI

interface FilmInfoView {

    fun setViewAdapterData(listFilmInfoUI: List<FilmInfoUI>)
}