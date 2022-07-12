package com.example.mvvmapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmapp.data.model.ContainerModel
import com.example.mvvmapp.domain.GetContainersUseCase
import kotlinx.coroutines.launch


class ContainerViewModel:ViewModel() {

    val containerModel = MutableLiveData<List<ContainerModel>>()

    val isLoading = MutableLiveData<Boolean>()

    var getContainerUseCase = GetContainersUseCase()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getContainerUseCase()

            if(!result.isNullOrEmpty()){
                isLoading.postValue(false)
                containerModel.postValue(result)
            }
        }
    }

}