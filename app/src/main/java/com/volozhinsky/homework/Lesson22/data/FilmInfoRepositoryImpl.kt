package com.volozhinsky.homework.Lesson22.data

import com.volozhinsky.homework.Lesson22.Server
import com.volozhinsky.homework.Lesson22.domain.repository.FilmInfoRepository
import com.volozhinsky.homework.Lesson22.data.models.FilmInfoResponse

class FilmInfoRepositoryImpl: FilmInfoRepository {

    override fun getFilmInfoList(): List<FilmInfoResponse> {
        return Server.getFilmListData()
    }
}