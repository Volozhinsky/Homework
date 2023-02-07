package com.volozhinsky.homework.Lesson22.domain

import com.volozhinsky.homework.Lesson22.domain.models.FilmInfo
import com.volozhinsky.homework.Lesson22.domain.repository.FilmInfoRepository
import javax.inject.Inject

class GetLowRatedFilmsListUseCase @Inject constructor(private val repository: FilmInfoRepository) {

    suspend  operator fun invoke(): List<FilmInfo> = repository.getFilmInfoList()
        .filter { it.Rated < LOW_RATING }

    companion object {

        private const val LOW_RATING = 8.8
    }
}