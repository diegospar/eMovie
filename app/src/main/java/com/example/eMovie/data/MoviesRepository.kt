package com.example.eMovie.data

import com.example.eMovie.data.model.MovieModel
import com.example.eMovie.data.model.MoviesProvider
import com.example.eMovie.data.network.MoviesService

class MoviesRepository {
    private val api = MoviesService()

    suspend fun getTopRatedMovies():List<MovieModel>{
        val response=api.getTopRatedMovies()
        MoviesProvider.upcomingMovies= response
        return response
    }

    suspend fun getUpcomingMovies():List<MovieModel>{
        val response=api.getUpcomingMovies()
        MoviesProvider.topRatedMovies= response
        return response
    }

    suspend fun getMoviesByLanguage():List<MovieModel>{
        val response=api.getMoviesByLanguage()
        MoviesProvider.moviesByLanguage= response
        return response
    }

    suspend fun getMoviesByDate():List<MovieModel>{
        val response=api.getMoviesByReleaseDate()
        MoviesProvider.moviesByDate= response
        return response
    }

}