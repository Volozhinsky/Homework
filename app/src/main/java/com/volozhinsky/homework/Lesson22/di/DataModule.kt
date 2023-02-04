package com.volozhinsky.homework.Lesson22.di

import com.volozhinsky.homework.Lesson22.data.FilmInfoRepositoryImpl
import com.volozhinsky.homework.Lesson22.domain.repository.FilmInfoRepository
import dagger.Binds
import dagger.Module

@Module
abstract class DataModule {

    @Binds
    abstract fun getFilmInfoRepository(impl: FilmInfoRepositoryImpl):FilmInfoRepository
}