package com.volozhinsky.homework.Lesson22.ui.film_describtion

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.volozhinsky.homework.Lesson22.domain.GetFilmDescribtionUseCase
import com.volozhinsky.homework.Lesson22.ui.mappers.FilmInfoMapperUI
import com.volozhinsky.homework.Lesson22.ui.models.FilmInfoUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FilmDescribtionViewModel @Inject constructor(
    private val useCase: GetFilmDescribtionUseCase,
    val mapper: FilmInfoMapperUI
): ViewModel() {

    private val _liveData = MutableLiveData<FilmInfoUI>()
    val liveData: LiveData<FilmInfoUI> get() = _liveData

    fun getFilmInfo(nameOfFilm: String) {
        viewModelScope.launch {
            val filmInfo = useCase(nameOfFilm)
            _liveData.value = mapper(filmInfo)
        }
    }
}