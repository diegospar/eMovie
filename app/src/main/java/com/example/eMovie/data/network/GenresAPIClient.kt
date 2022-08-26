package com.example.eMovie.data.network

import com.example.eMovie.data.model.GenreModel
import com.example.eMovie.data.model.GenreResponseModel
import com.example.eMovie.data.model.MovieResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GenresAPIClient {
    @GET("genre/movie/list")
    suspend fun getGenres(
        @Query("api_key") apikey:String = "d46dcd1e5f99055a125de6b4a46ddf13",
        @Query("language") language:String? = "es-MX"
    ): Response<GenreResponseModel>
}