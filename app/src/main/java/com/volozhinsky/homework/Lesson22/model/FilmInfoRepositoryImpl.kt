package com.volozhinsky.homework.Lesson22.model

import com.volozhinsky.homework.Lesson22.model.models.FilmInfo

class FilmInfoRepositoryImpl:FilmInfoRepository {

    override fun getFilmInfoList(): List<FilmInfo> {
        return Server.getFilmListData()
    }
}