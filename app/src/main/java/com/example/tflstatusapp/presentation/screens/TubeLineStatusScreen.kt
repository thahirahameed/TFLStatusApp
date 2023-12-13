package com.example.tflstatusapp.presentation.screens

import TubeLineCard
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.tflstatusapp.presentation.viewmodel.TubeLineStatusViewModel

@Composable
fun TubeLineStatusScreen(
    navHostController: NavHostController,
    viewModel: TubeLineStatusViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val scroll = rememberScrollState(0)
    Column(
        modifier = Modifier
            .padding(top = 15.dp)
            .padding(start = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Status Updates",
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        )

        Text(
            text = "Status Updates which have to scroll infinitely Just cheking if it actually works",
            color = Color.Blue,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.horizontalScroll(scroll)
        )
        Column(
            modifier = Modifier
                .padding(top = 15.dp)
        ) {

            LazyColumn() {
                items(state.tubeLineStatus) { response ->
                    Spacer(modifier = Modifier.padding(5.dp))
                    Row() {
                        TubeLineCard(tubeLineResponsesItem = response)
                    }
                }
            }

        }
    }
}