package com.example.shivam_agarwal.presentation

sealed class UiState {
    object Start : UiState()
    data class Loading(val isLoading: Boolean) : UiState()
    data class Success(val data: Any) : UiState()
    data class Error(val exception: String) : UiState()
}