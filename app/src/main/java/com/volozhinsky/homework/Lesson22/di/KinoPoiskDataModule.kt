package com.volozhinsky.homework.Lesson22.di

import com.volozhinsky.homework.Lesson22.data.network.KinopoiskService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object KinoPoiskDataModule {

    @Provides
    fun provideKinopoiskService( ):KinopoiskService{
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.kinopoisk.dev/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(KinopoiskService::class.java)
    }

}