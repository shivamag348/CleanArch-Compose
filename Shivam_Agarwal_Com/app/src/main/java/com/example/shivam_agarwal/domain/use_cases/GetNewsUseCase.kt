package com.example.shivam_agarwal.domain.use_cases

import com.example.shivam_agarwal.data.remote.model.ArticlesResponse
import com.example.shivam_agarwal.domain.repository.MainRepository
import com.example.shivam_agarwal.util.NetworkResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(
    private val mainRepository: MainRepository
) {

    operator fun invoke(source: String, apiKey: String, pageSize: Int, pageNo: Int) : Flow<NetworkResult<ArticlesResponse>> {
        return mainRepository.getNewsResponse(source, apiKey, pageSize, pageNo)
    }

}