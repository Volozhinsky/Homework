package com.volozhinsky.homework.Lesson22.domain

import com.volozhinsky.homework.Lesson22.domain.models.FilmInfo
import com.volozhinsky.homework.Lesson22.domain.repository.FilmInfoRepository
import javax.inject.Inject

class GetFilmDescribtionUseCase @Inject constructor(private val repository: FilmInfoRepository) {

    operator fun invoke(querry: String): FilmInfo = repository.getFilmInfoList().find { it.name == querry } ?: FilmInfo("",0.0,false,"","")
}