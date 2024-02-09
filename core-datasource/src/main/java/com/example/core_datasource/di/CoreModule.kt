package com.example.core_datasource.di

import com.example.core_datasource.core.PhotosRepository
import com.example.core_datasource.core.PhotosRepositoryImpl
import com.example.core_network.PhotosApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoreModule {

    @Provides
    @Singleton
    fun providesDashCoinRepository(
        api: PhotosApi,
    ): PhotosRepository {
        return PhotosRepositoryImpl(
            api,
        )
    }
}