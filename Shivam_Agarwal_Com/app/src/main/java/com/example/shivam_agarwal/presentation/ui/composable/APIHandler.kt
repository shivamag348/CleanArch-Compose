package com.example.shivam_agarwal.presentation.ui.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.shivam_agarwal.data.remote.model.ArticlesResponse
import com.example.shivam_agarwal.presentation.MainViewModel
import com.example.shivam_agarwal.presentation.UiState

@Composable
fun APIHandler() {
    val viewModel: MainViewModel = hiltViewModel()

    val state = viewModel.newsState

    LaunchedEffect(Unit) {
        viewModel.getNewsResponse()
    }


    when (state) {
        is UiState.Start -> {
        }
        is UiState.Loading -> {
            Column(horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {
                CircularProgressIndicator(modifier = Modifier.size(50.dp))
            }
        }
        is UiState.Success -> {
            val data = state.data as ArticlesResponse
            data.articles?.let { LazyListing(it) }
        }
        is UiState.Error -> {
            Text(text = state.exception)
        }
    }

}