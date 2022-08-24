package com.example.eMovie.data.network

import com.example.eMovie.core.RetrofitHelper
import com.example.eMovie.data.model.MovieModel
import kotlinx.coroutines.flow.callbackFlow

class MoviesService {

    private val retrofit = RetrofitHelper.getRetrofitMovie()

    suspend fun getUpcomingMovies(): List<MovieModel> {
        val response = retrofit.create(MoviesRequestsAPIClient::class.java).getMovies("upcoming")
        return response. body()?.movies ?: emptyList()

    }

    suspend fun getTopRatedMovies(): List<MovieModel> {
        val response = retrofit.create(MoviesRequestsAPIClient::class.java).getMovies("top_rated")
        return response.body()?.movies ?: emptyList()

    }

}