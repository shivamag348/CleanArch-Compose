package com.example.shivam_agarwal.domain.repository

import com.example.shivam_agarwal.data.model.Article
import com.example.shivam_agarwal.data.remote.model.ArticlesResponse
import com.example.shivam_agarwal.util.NetworkResult
import kotlinx.coroutines.flow.Flow


interface MainRepository {
   fun getNewsResponse(source: String, apiKey: String, pageSize: Int, pageNo: Int): Flow<NetworkResult<ArticlesResponse>>
}