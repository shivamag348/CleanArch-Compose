package com.example.shivam_agarwal.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shivam_agarwal.domain.use_cases.GetNewsUseCase
import com.example.shivam_agarwal.util.NetworkResult
import com.example.shivam_agarwal.util.AppConstant
import com.example.shivam_agarwal.util.findCharsAtEveryIndex
import com.example.shivam_agarwal.util.getWordFrequency
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val getNewsUseCase: GetNewsUseCase
) : ViewModel() {

    var newsState by mutableStateOf<UiState>(UiState.Start)
        private set


    fun getNewsResponse() {
        getNewsUseCase.invoke("bbc-news", "1b78944bbeac49d3a225bcfd448fffe1", 10, 1)
            .onEach { response ->
                when (response) {
                    is NetworkResult.Loading -> {
                        newsState = UiState.Loading(true)
                    }
                    is NetworkResult.Success -> {
                        response.data?.let {
                            newsState = UiState.Success(it)
                        }
                    }
                    is NetworkResult.Error -> {
                        newsState = UiState.Error(response.errorMessage?:"Error")
                    }
                }
            }.launchIn(viewModelScope)

    }


}