package com.volozhinsky.homework.Lesson22.ui

import com.volozhinsky.homework.Lesson22.model.models.FilmInfo

interface FilmInfoView {
    fun setViewAdapterData(listFilmInfo: List<FilmInfo>)
}