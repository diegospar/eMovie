package com.example.eMovie.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eMovie.data.model.VideoModel
import com.example.eMovie.domain.GetVideoUseCase
import kotlinx.coroutines.launch

class DetailViewModel: ViewModel() {


    val video= MutableLiveData<List<VideoModel>>()

    var getVideoUseCase = GetVideoUseCase()

    fun onCreate(movieID: String) {
        viewModelScope.launch {
            val videoURL = getVideoUseCase(movieID)
            if(!videoURL.isNullOrEmpty()){
                this@DetailViewModel.video.postValue(videoURL)
            }
        }
    }
}