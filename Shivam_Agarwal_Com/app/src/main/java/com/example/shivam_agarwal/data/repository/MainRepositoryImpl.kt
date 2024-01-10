package com.example.shivam_agarwal.data.repository

import com.example.shivam_agarwal.data.model.Article
import com.example.shivam_agarwal.util.NetworkResult
import com.example.shivam_agarwal.data.remote.BaseApiResponse
import com.example.shivam_agarwal.data.remote.GetBlogRemoteDataSource
import com.example.shivam_agarwal.data.remote.model.ArticlesResponse
import com.example.shivam_agarwal.domain.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class MainRepositoryImpl @Inject constructor(
    private val blogRemoteDataSource: GetBlogRemoteDataSource
    ): MainRepository, BaseApiResponse() {

    override fun getNewsResponse(source: String, apiKey: String, pageSize: Int, pageNo: Int): Flow<NetworkResult<ArticlesResponse>> {
        return flow {
            emit(NetworkResult.Loading())
            emit(safeApiCall { blogRemoteDataSource.getTopHeadlines(source, apiKey, pageSize, pageNo)})
        }.flowOn(Dispatchers.IO)
    }

}