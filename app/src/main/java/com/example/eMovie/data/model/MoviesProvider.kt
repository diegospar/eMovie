package com.example.eMovie.data.model

class MoviesProvider {
    companion object {
        var upcomingMovies: List<MovieModel> = emptyList()
        var topRatedMovies: List<MovieModel> = emptyList()
        var moviesByLanguage: List<MovieModel> = emptyList()
        var moviesByDate: List<MovieModel> = emptyList()
    }
}