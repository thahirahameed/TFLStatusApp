package com.example.tflstatusapp.domain.use_case

import com.example.tflstatusapp.data.remote.TubeLineResponsesItem
import com.example.tflstatusapp.domain.repo.TubeLineRepository
import com.example.tflstatusapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import retrofit2.HttpException
import javax.inject.Inject

class TubeStatusUseCase @Inject constructor(
    private val repository: TubeLineRepository
) {
    operator fun invoke(): Flow<Resource<List<TubeLineResponsesItem>>> = flow{
        try {
            emit(Resource.Loading())
            val tubeStatus = repository.getTubeLineStatus().map { it }
            emit(Resource.Success(tubeStatus))
        }catch (e: HttpException){
            emit(
                Resource.Error<List<TubeLineResponsesItem>>(
                    e.localizedMessage ?: "An unexpected error occurred"
                )
            )
        }catch ( e: IOException){
            emit(
                Resource.Error<List<TubeLineResponsesItem>>(
                    "Couldn't  reach server. Check your internet connection."
                )
            )
        }
    }
}