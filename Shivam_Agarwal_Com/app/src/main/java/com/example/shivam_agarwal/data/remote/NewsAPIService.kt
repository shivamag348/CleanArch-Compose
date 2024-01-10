package com.example.shivam_agarwal.data.remote

import com.example.shivam_agarwal.data.remote.model.ArticlesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPIService {

    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("sources") source: String,
        @Query("apiKey") apiKey: String,
        @Query("pageSize") pageSize: Int,
        @Query("page") pageNo: Int
    ) : Response<ArticlesResponse>

    companion object {
        const val BASE_URL = "https://newsapi.org/v2/"

    }

}