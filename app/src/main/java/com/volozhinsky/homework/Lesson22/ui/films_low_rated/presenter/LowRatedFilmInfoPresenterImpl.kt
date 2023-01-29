package com.volozhinsky.homework.Lesson22.ui.films_low_rated.presenter


import com.volozhinsky.homework.Lesson22.domain.GetLowRatedFilmsListUseCase
import com.volozhinsky.homework.Lesson22.ui.films_low_rated.LowRatedFilmInfoView
import com.volozhinsky.homework.Lesson22.ui.mappers.FilmInfoMapperUI

class LowRatedFilmInfoPresenterImpl(private var view:LowRatedFilmInfoView?):LowRatedFilmInfoPresenter {

    private val useCase = GetLowRatedFilmsListUseCase()
    private val mapper = FilmInfoMapperUI()

    override fun getLowRatedFilmInfo() {
        view?.setViewAdapterData(useCase().map {mapper(it) })
    }

    override fun onClear() {
        view = null
    }
}

