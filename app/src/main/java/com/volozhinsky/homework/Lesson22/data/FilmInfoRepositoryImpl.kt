package com.volozhinsky.homework.Lesson22.data

import com.volozhinsky.homework.Lesson22.data.mappers.FilmInfoMapper
import com.volozhinsky.homework.Lesson22.data.mappers.UserFavoritesMapper
import com.volozhinsky.homework.Lesson22.domain.models.FilmInfo
import com.volozhinsky.homework.Lesson22.domain.models.UserFavorites
import com.volozhinsky.homework.Lesson22.domain.repository.FilmInfoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FilmInfoRepositoryImpl @Inject constructor(
    val mapper: FilmInfoMapper,
    val userFavoritesMapper: UserFavoritesMapper
) : FilmInfoRepository {

    override suspend fun getFilmInfoList(): List<FilmInfo> {
        return withContext(Dispatchers.IO) {
            Server.getFilmListData().map { mapper(it) }
        }
    }

    override suspend fun getFilmByName(name: String): FilmInfo {
        return mapper(Server.getFilmByName(name))
    }

    override suspend fun getUser(): UserFavorites {
        return userFavoritesMapper(Server.getUser())
    }
}