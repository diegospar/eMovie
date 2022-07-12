package com.example.mvvmapp.data

import com.example.mvvmapp.data.model.ContainerModel
import com.example.mvvmapp.data.model.ContainerProvider
import com.example.mvvmapp.data.network.ContainerService

class ContainerRepository {
    private val api = ContainerService()

    suspend fun getContainers():List<ContainerModel>{
        val response=api.getContainers()
        ContainerProvider.containers= response
        return response
    }
}