package com.example.eMovie.data.network

import com.example.eMovie.data.model.GenreResponseModel
import com.example.eMovie.data.model.VideoResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface VideoAPIClient {
    @GET("movie/{movieID}/videos")
    suspend fun getVideo(
        @Path("movieID") movieID:String,
        @Query("api_key") apikey:String = "d46dcd1e5f99055a125de6b4a46ddf13",
    ): Response<VideoResponseModel>
}