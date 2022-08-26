package com.example.eMovie.domain

import com.example.eMovie.data.MoviesRepository
import com.example.eMovie.data.model.GenreModel
import com.example.eMovie.data.model.VideoModel

class GetVideoUseCase {
    private val repository = MoviesRepository()

    suspend operator fun invoke(movieID: String):List<VideoModel>? = repository.getVideo(movieID)
}