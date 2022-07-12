package com.example.mvvmapp.data.network

import com.example.mvvmapp.data.model.ContainerModel
import retrofit2.Response
import retrofit2.http.GET

interface ContainerApiClient {
    @GET("/.json")
    suspend fun getContainers(): Response<List<ContainerModel>>
}