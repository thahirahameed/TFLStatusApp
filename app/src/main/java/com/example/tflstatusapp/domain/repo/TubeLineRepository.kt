package com.example.tflstatusapp.domain.repo

import com.example.tflstatusapp.data.remote.TubeLineResponses

interface TubeLineRepository {
    suspend fun  getTubeLineStatus(): TubeLineResponses
}