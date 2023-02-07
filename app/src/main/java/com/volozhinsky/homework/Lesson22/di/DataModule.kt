package com.volozhinsky.homework.Lesson22.di

import com.volozhinsky.homework.Lesson22.data.FilmInfoRepositoryImpl
import com.volozhinsky.homework.Lesson22.domain.repository.FilmInfoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun getFilmInfoRepository(impl: FilmInfoRepositoryImpl):FilmInfoRepository
}