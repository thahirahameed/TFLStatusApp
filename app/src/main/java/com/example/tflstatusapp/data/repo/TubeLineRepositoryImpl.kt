package com.example.tflstatusapp.data.repo

import com.example.tflstatusapp.data.TubeLinesApi
import com.example.tflstatusapp.data.remote.TubeLineResponses
import com.example.tflstatusapp.domain.repo.TubeLineRepository
import javax.inject.Inject

class TubeLineRepositoryImpl @Inject constructor(
    private val api: TubeLinesApi
): TubeLineRepository {

    override suspend fun getTubeLineStatus(): TubeLineResponses{
        return api.getTubeLineStatus()
    }
}