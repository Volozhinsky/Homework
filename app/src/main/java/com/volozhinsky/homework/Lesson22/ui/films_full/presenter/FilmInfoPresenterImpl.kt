package com.volozhinsky.homework.Lesson22.ui.films_full.presenter

import com.volozhinsky.homework.Lesson22.domain.repository.FilmInfoRepository
import com.volozhinsky.homework.Lesson22.data.FilmInfoRepositoryImpl
import com.volozhinsky.homework.Lesson22.ui.films_full.FilmInfoView
import com.volozhinsky.homework.Lesson22.ui.mappers.FilmInfoMapperUI

class FilmInfoPresenterImpl(private var view: FilmInfoView?): FilmInfoPresenter {

    private val repository: FilmInfoRepository = FilmInfoRepositoryImpl()

    override fun getFilmInfo() {
        val mapper = FilmInfoMapperUI()
        val listFilmInfo = repository.getFilmInfoList().map {mapper(it)}
        view?.setViewAdapterData(listFilmInfo)
    }

    override fun onClear() {
        view = null
    }
}