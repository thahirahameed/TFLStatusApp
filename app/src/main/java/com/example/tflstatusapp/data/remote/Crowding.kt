package com.example.tflstatusapp.data.remote


import com.google.gson.annotations.SerializedName

data class Crowding(
    @SerializedName("type")
    val type: String
)