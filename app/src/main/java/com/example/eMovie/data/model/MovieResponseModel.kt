package com.example.eMovie.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


data class MovieResponseModel(
    @SerializedName("results") var movies: List<MovieModel>
)
