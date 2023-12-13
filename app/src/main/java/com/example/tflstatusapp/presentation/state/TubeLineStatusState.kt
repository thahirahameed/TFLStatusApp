package com.example.tflstatusapp.presentation.state

import com.example.tflstatusapp.data.remote.TubeLineResponsesItem

data class TubeLineStatusState(
    val isLoading: Boolean = false,
    val tubeLineStatus: List<TubeLineResponsesItem> = emptyList(),
    val error:String =""
)
