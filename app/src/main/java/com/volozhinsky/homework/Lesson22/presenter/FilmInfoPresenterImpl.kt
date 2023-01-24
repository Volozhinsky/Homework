package com.volozhinsky.homework.Lesson22.presenter

import android.view.View
import com.volozhinsky.homework.Lesson22.model.FilmInfoRepository
import com.volozhinsky.homework.Lesson22.model.FilmInfoRepositoryImpl
import com.volozhinsky.homework.Lesson22.ui.FilmInfoView

class FilmInfoPresenterImpl(private var view:FilmInfoView?):FilmInfoPresenter {

    private val repository: FilmInfoRepository = FilmInfoRepositoryImpl()

    override fun getFilmInfo() {
        val listFilmInfo = repository.getFilmInfoList()
        view?.setViewAdapterData(listFilmInfo)
    }

    override fun onClear() {
        view = null
    }
}