package com.example.eMovie.domain

import com.example.eMovie.data.MoviesRepository
import com.example.eMovie.data.model.GenreModel

class GetGenresUseCase {
    private val repository = MoviesRepository()

    suspend operator fun invoke():List<GenreModel>? = repository.getGenres()
}