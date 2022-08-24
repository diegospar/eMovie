package com.example.eMovie.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eMovie.data.model.MovieModel
import com.example.eMovie.domain.GetTopRatedMoviesUseCase
import kotlinx.coroutines.launch


class MoviesViewModel:ViewModel() {

    val topRatedMovies = MutableLiveData<List<MovieModel>>()

    val upcomingMovies = MutableLiveData<List<MovieModel>>()

    val isLoading = MutableLiveData<Boolean>()

    var getTopRatedMoviesUseCase = GetTopRatedMoviesUseCase()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val topRatedMovies = getTopRatedMoviesUseCase()

            if(!topRatedMovies.isNullOrEmpty()){
                isLoading.postValue(false)
                this@MoviesViewModel.topRatedMovies.postValue(topRatedMovies)
            }
        }
    }

}