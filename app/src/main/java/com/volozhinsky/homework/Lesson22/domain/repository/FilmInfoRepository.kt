package com.volozhinsky.homework.Lesson22.domain.repository

import com.volozhinsky.homework.Lesson22.domain.models.FilmInfo

interface FilmInfoRepository {
    fun getFilmInfoList():List<FilmInfo>
}