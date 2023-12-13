package com.example.tflstatusapp.data

import com.example.tflstatusapp.data.remote.TubeLineResponses
import retrofit2.http.GET

interface TubeLinesApi {

    @GET("Line/Mode/Tube/Status")
    suspend fun getTubeLineStatus(): TubeLineResponses

    //https://api.tfl.gov.uk/Line/Mode/Tube/Status
}