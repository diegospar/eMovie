package com.example.eMovie.data.model

import com.google.gson.annotations.SerializedName

data class GenreResponseModel(
    @SerializedName("genres") var genres: List<GenreModel>
)