package com.volozhinsky.homework.Lesson22.domain

import com.volozhinsky.homework.Lesson22.domain.models.FilmInfo
import com.volozhinsky.homework.Lesson22.domain.repository.FilmInfoRepository
import javax.inject.Inject

class GetFavoriteUserFilmUseCase @Inject constructor(private val repository: FilmInfoRepository) {

    suspend operator fun invoke(): FilmInfo {
        val userFavorites = repository.getUser()
        return repository.getFilmByName(userFavorites.favoriteFilmName)
    }
}