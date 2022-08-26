package com.example.eMovie.data.model

import com.google.gson.annotations.SerializedName

data class VideoResponseModel(
    @SerializedName("results") var video: List<VideoModel>
)