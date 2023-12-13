package com.example.tflstatusapp.data.remote


import com.google.gson.annotations.SerializedName

data class ValidityPeriod(
    @SerializedName("fromDate")
    val fromDate: String,
    @SerializedName("isNow")
    val isNow: Boolean,
    @SerializedName("toDate")
    val toDate: String,
    @SerializedName("type")
    val type: String
)