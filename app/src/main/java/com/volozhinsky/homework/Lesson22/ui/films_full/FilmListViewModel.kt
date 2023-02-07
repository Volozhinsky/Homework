package com.volozhinsky.homework.Lesson22.ui.films_full

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.volozhinsky.homework.Lesson22.domain.repository.FilmInfoRepository
import com.volozhinsky.homework.Lesson22.ui.mappers.FilmInfoMapperUI
import com.volozhinsky.homework.Lesson22.ui.models.FilmInfoUI
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FilmListViewModel @Inject constructor(
    private val repository: FilmInfoRepository,
    val mapper: FilmInfoMapperUI
) :ViewModel() {

    private val _liveData = MutableLiveData<List<FilmInfoUI>>()
    val liveData: LiveData<List<FilmInfoUI>> get() = _liveData

    fun getFilmInfo() {
        val listFilmInfo = repository.getFilmInfoList().map {mapper(it)}
        _liveData.value = listFilmInfo
    }
}