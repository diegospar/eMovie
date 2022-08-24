package com.example.eMovie.data.network

import com.example.eMovie.data.model.MovieResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesRequestsAPIClient {
    @GET("movie/{typeOfRequest}")
    suspend fun getMovies(
        @Path("typeOfRequest") typeOfRequest:String,
        @Query ("api_key") apikey:String = "d46dcd1e5f99055a125de6b4a46ddf13",
        @Query ("language") language:String = "es-MX",
        @Query("page") page: Int = 1,
        @Query("region") region: String = "US"
    ): Response<MovieResponseModel>
}