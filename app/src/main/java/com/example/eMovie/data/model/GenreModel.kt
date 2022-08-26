package com.example.eMovie.data.model

import com.google.gson.annotations.SerializedName

class GenreModel (
    @SerializedName("id") var id: String,
    @SerializedName("name") var genreName:String
)