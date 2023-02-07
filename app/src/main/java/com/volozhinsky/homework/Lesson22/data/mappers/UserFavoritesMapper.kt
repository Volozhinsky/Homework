package com.volozhinsky.homework.Lesson22.data.mappers

import com.volozhinsky.homework.Lesson22.data.models.UserFavoritesResponse
import com.volozhinsky.homework.Lesson22.domain.models.UserFavorites
import javax.inject.Inject

class UserFavoritesMapper @Inject constructor() {
    operator fun invoke(response: UserFavoritesResponse) = with(response) {
        UserFavorites(
            userId = userId ?: "",
            favoriteFilmName = favoriteFilmName ?: ""
        )
    }
}