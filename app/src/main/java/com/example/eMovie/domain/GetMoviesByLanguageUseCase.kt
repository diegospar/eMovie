package com.example.eMovie.domain

import com.example.eMovie.data.MoviesRepository
import com.example.eMovie.data.model.MovieModel

class GetMoviesByLanguageUseCase {
    private val repository = MoviesRepository()

    suspend operator fun invoke():List<MovieModel>? = repository.getMoviesByLanguage()

}