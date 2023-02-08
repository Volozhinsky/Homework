package com.volozhinsky.homework.Lesson22.domain.repository

import com.volozhinsky.homework.Lesson22.domain.models.FilmInfo
import com.volozhinsky.homework.Lesson22.domain.models.UserFavorites

interface FilmInfoRepository {
    suspend fun getFilmInfoList(): List<FilmInfo>
    suspend fun getFilmByName(name: String): FilmInfo
    suspend fun getUser(): UserFavorites
}