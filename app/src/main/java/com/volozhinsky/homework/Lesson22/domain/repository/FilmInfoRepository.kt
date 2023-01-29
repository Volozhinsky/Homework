package com.volozhinsky.homework.Lesson22.domain.repository

import com.volozhinsky.homework.Lesson22.data.models.FilmInfoResponse

interface FilmInfoRepository {
    fun getFilmInfoList():List<FilmInfoResponse>
}