package com.example.eMovie.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieModel(
    @SerializedName("id") var id: String?,
    @SerializedName("title") var title:String,
    @SerializedName("poster_path") var poster: String,
    @SerializedName("original_language") var language: String,
    @SerializedName("vote_average") var average: String,
    @SerializedName("release_date") var date:String,
    @SerializedName("overview") var description:String,
    @SerializedName("genre_ids") var genres:List<Int>
): Parcelable