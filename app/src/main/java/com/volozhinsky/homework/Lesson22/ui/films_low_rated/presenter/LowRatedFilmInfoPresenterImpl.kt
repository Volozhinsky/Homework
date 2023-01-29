package com.volozhinsky.homework.Lesson22.ui.films_low_rated.presenter

import com.volozhinsky.homework.Lesson22.data.FilmInfoRepositoryImpl
import com.volozhinsky.homework.Lesson22.domain.GetLowRatedFilmsListUseCase
import com.volozhinsky.homework.Lesson22.domain.repository.FilmInfoRepository
import com.volozhinsky.homework.Lesson22.ui.films_low_rated.LowRatedFilmInfoView

class LowRatedFilmInfoPresenterImpl(private var view:LowRatedFilmInfoView?):LowRatedFilmInfoPresenter {

    private val useCase = GetLowRatedFilmsListUseCase()

    override fun getLowRatedFilmInfo() {
        view?.setViewAdapterData(useCase())
    }

    override fun onClear() {
        view = null
    }
}

