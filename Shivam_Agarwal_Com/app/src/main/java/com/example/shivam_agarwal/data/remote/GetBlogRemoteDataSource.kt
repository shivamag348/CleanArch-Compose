package com.example.shivam_agarwal.data.remote

import javax.inject.Inject


class GetBlogRemoteDataSource @Inject constructor(
    private val newsAPIService: NewsAPIService,
) {

    suspend fun getTopHeadlines(source: String, apiKey: String, pageSize: Int, pageNo: Int
    ) = newsAPIService.getTopHeadlines(
        source, apiKey, pageSize, pageNo
    )


}