package com.example.mvvmapp.data.network

import com.example.mvvmapp.core.RetrofitHelper
import com.example.mvvmapp.data.model.ContainerModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ContainerService {

    private val retrofit = RetrofitHelper.getRetrofitContainer()

    suspend fun getContainers():List<ContainerModel>{
        return withContext(Dispatchers.IO){
            val response=retrofit.create(ContainerApiClient::class.java).getContainers()
            response.body() ?: emptyList()
        }
    }

}