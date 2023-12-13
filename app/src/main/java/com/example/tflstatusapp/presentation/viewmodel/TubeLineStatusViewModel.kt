package com.example.tflstatusapp.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tflstatusapp.domain.use_case.TubeStatusUseCase
import com.example.tflstatusapp.presentation.state.TubeLineStatusState
import com.example.tflstatusapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class TubeLineStatusViewModel @Inject constructor(
    private val tubeStatusUseCase: TubeStatusUseCase
): ViewModel(){

    private val _state = mutableStateOf(TubeLineStatusState())
    val state: State<TubeLineStatusState> = _state

    init {
        getTubeLineStatus()
    }

    fun getTubeLineStatus(){
        tubeStatusUseCase().onEach { result ->
            when(result){
                is Resource.Success -> {
                    _state.value = TubeLineStatusState(tubeLineStatus = (result.data ?: emptyList()))
                }
                is Resource.Error -> {
                    _state.value = TubeLineStatusState(error = (result.message ?: "An unexpected error occurred"))
                }
                is Resource.Loading -> {
                    _state.value = TubeLineStatusState(isLoading = true)
                }

                else -> {
                    _state.value = TubeLineStatusState(error = (result.message ?: "Some error occurred"))
                }
            }
        }.launchIn(viewModelScope)
    }
}