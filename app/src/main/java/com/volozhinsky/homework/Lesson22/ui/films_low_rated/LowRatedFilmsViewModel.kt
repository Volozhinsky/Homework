package com.volozhinsky.homework.Lesson22.ui.films_low_rated

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.volozhinsky.homework.Lesson22.domain.GetLowRatedFilmsListUseCase
import com.volozhinsky.homework.Lesson22.ui.mappers.FilmInfoMapperUI
import com.volozhinsky.homework.Lesson22.ui.models.FilmInfoUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LowRatedFilmsViewModel @Inject constructor(
    private val useCase: GetLowRatedFilmsListUseCase,
    val mapper: FilmInfoMapperUI
):ViewModel() {

    private val _liveData = MutableLiveData<List<FilmInfoUI>>()
    val liveData: LiveData<List<FilmInfoUI>> get() = _liveData

    fun getFilmInfo() {
        viewModelScope.launch {
            val listFilmInfo = useCase().map {mapper(it) }
            _liveData.value = listFilmInfo
        }
    }
}