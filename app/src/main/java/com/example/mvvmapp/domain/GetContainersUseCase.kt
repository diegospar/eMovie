package com.example.mvvmapp.domain

import com.example.mvvmapp.data.ContainerRepository
import com.example.mvvmapp.data.model.ContainerModel

class GetContainersUseCase {

    private val repository = ContainerRepository()

    suspend operator fun invoke():List<ContainerModel>? = repository.getContainers()

}