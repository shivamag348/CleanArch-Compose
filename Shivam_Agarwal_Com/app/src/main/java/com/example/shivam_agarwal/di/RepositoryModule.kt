package com.example.shivam_agarwal.di

import com.example.shivam_agarwal.data.remote.GetBlogRemoteDataSource
import com.example.shivam_agarwal.data.remote.NewsAPIService
import com.example.shivam_agarwal.data.repository.MainRepositoryImpl
import com.example.shivam_agarwal.domain.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideGetBlogRemoteDataSource(
        newsAPIService: NewsAPIService
    ) : GetBlogRemoteDataSource = GetBlogRemoteDataSource(newsAPIService)

    @Provides
    @Singleton
    fun provideMainRepository(
        blogRemoteDataSource: GetBlogRemoteDataSource
    ) : MainRepository = MainRepositoryImpl(blogRemoteDataSource)

}