package com.volozhinsky.homework.Lesson22.data

import com.volozhinsky.homework.Lesson22.data.mappers.FilmInfoMapper
import com.volozhinsky.homework.Lesson22.domain.models.FilmInfo
import com.volozhinsky.homework.Lesson22.domain.repository.FilmInfoRepository
import javax.inject.Inject

class FilmInfoRepositoryImpl @Inject constructor(val mapper: FilmInfoMapper) : FilmInfoRepository {

    override fun getFilmInfoList(): List<FilmInfo> {
        return Server.getFilmListData().map { mapper(it) }
    }
}