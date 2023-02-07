package com.volozhinsky.homework.Lesson22.ui.films_full

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.volozhinsky.homework.Lesson22.domain.GetFavoriteUserFilmUseCase
import com.volozhinsky.homework.Lesson22.domain.GetFilmDescribtionUseCase
import com.volozhinsky.homework.Lesson22.domain.repository.FilmInfoRepository
import com.volozhinsky.homework.Lesson22.ui.mappers.FilmInfoMapperUI
import com.volozhinsky.homework.Lesson22.ui.models.FilmInfoUI
import com.volozhinsky.homework.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import java.net.SocketTimeoutException
import javax.inject.Inject

@HiltViewModel
class FilmListViewModel @Inject constructor(
    private val repository: FilmInfoRepository,
    private val mapper: FilmInfoMapperUI,
    private val useCase: GetFavoriteUserFilmUseCase,
) : ViewModel() {

    private val _liveData = MutableLiveData<List<FilmInfoUI>>()
    val liveData: LiveData<List<FilmInfoUI>> get() = _liveData

    private val _errorliveData = MutableLiveData<Int>()
    val errorliveData: LiveData<Int> get() = _errorliveData

    private val _progressBarliveData = MutableLiveData<Boolean>()
    val progressBarliveData: LiveData<Boolean> get() = _progressBarliveData

    private val _describtionFavoriteFilm = MutableLiveData<String>()
    val describtionFavoriteFilm: LiveData<String> get() = _describtionFavoriteFilm


    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        when (throwable) {
            is SocketTimeoutException -> _errorliveData.value = R.string.timeoutEx
            else -> _errorliveData.value = R.string.unknownEx

        }
        _progressBarliveData.value = false

    }

    fun getFilmInfo() {
        viewModelScope.launch(exceptionHandler) {
            _progressBarliveData.value = true
            val listFilmInfo = repository.getFilmInfoList().map { mapper(it) }
            _liveData.value = listFilmInfo
            _progressBarliveData.value = false
        }
    }

    fun showFavorites() {
        viewModelScope.launch {
            _describtionFavoriteFilm.value = mapper(useCase.invoke()).description
        }
    }
}