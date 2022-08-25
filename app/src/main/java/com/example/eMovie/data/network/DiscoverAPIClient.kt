package com.example.eMovie.data.network

import com.example.eMovie.data.model.MovieResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DiscoverAPIClient {
    @GET("discover/movie")
    suspend fun getMovies(
        @Query("api_key") apikey:String = "d46dcd1e5f99055a125de6b4a46ddf13",
        @Query("language") language:String? = null,
        @Query("primary_release_year") year: Int? =null,
        @Query("page") page: Int = 1,
        @Query("region") region: String = "US"
    ): Response<MovieResponseModel>
}