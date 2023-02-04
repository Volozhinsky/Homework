package com.volozhinsky.homework.Lesson22.ui.films_low_rated.presenter


import com.volozhinsky.homework.Lesson22.domain.GetLowRatedFilmsListUseCase
import com.volozhinsky.homework.Lesson22.ui.films_low_rated.LowRatedFilmInfoView
import com.volozhinsky.homework.Lesson22.ui.mappers.FilmInfoMapperUI
import javax.inject.Inject

class LowRatedFilmInfoPresenterImpl @Inject constructor(private val useCase: GetLowRatedFilmsListUseCase,
                                    private var view: LowRatedFilmInfoView?,
                                    private val mapper: FilmInfoMapperUI):LowRatedFilmInfoPresenter {

    override fun getLowRatedFilmInfo() {
        view?.setViewAdapterData(useCase().map {mapper(it) })
    }

    override fun onClear() {
        view = null
    }
}

