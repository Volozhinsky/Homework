package com.volozhinsky.homework.Lesson22.model

import com.volozhinsky.homework.Lesson22.model.models.FilmInfo

interface FilmInfoRepository {
    fun getFilmInfoList():List<FilmInfo>
}