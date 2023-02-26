package com.volozhinsky.homework.Lesson22.data.network

import com.volozhinsky.homework.Lesson22.data.models.FilmInfoResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface KinopoiskService {
    @GET("movie")
    fun getMovie(@Query("field")field: String, @Query("search") rating:String ):List<FilmInfoResponse>
}