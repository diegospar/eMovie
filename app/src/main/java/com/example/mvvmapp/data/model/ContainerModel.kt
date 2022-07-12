package com.example.mvvmapp.data.model

import com.google.gson.annotations.SerializedName

data class ContainerModel (@SerializedName("tipo") val tipo:String, @SerializedName("direccion") val direccion:String)