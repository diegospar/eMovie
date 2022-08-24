package com.example.eMovie.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eMovie.data.model.MovieModel
import com.example.eMovie.domain.GetTopRatedMoviesUseCase
import com.example.eMovie.domain.GetUpcomingMoviesUseCase
import kotlinx.coroutines.launch


class HomeViewModel:ViewModel() {

    val topRatedMovies = MutableLiveData<List<MovieModel>>()

    val upcomingMovies = MutableLiveData<List<MovieModel>>()

    val category1IsLoading = MutableLiveData<Boolean>()
    val category2IsLoading = MutableLiveData<Boolean>()
    val category3IsLoading = MutableLiveData<Boolean>()

    var getTopRatedMoviesUseCase = GetTopRatedMoviesUseCase()
    var getUpcomingMoviesUseCase = GetUpcomingMoviesUseCase()

    fun onCreate() {
        viewModelScope.launch {
            category1IsLoading.postValue(true)
            category2IsLoading.postValue(true)
           // category3IsLoading.postValue(true)
            val topRatedMovies = getTopRatedMoviesUseCase()
            val upcomingMovies = getUpcomingMoviesUseCase()

            if(!topRatedMovies.isNullOrEmpty()){
                category1IsLoading.postValue(false)
                this@HomeViewModel.topRatedMovies.postValue(topRatedMovies)
            }
            if(!upcomingMovies.isNullOrEmpty()){
                category2IsLoading.postValue(false)
                this@HomeViewModel.upcomingMovies.postValue(topRatedMovies)
            }
        }
    }

}