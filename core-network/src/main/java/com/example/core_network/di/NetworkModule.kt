package com.example.core_network.di

import com.example.core.Constants.BASE_URL
import com.example.core_network.PhotosApi
import com.example.core_network.interceptor.OkhttpInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object NetworkModule {

    @Provides
    @Singleton
    fun providesOkhttpInterceptor(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder()
            .addInterceptor(OkhttpInterceptor())
            .addInterceptor(loggingInterceptor)
            .addNetworkInterceptor { chain ->
                val requestBuilder = chain.request().newBuilder()
                requestBuilder.header("accept", "application/json")
                chain.proceed(requestBuilder.build())
            }
            .build()
    }

    @Provides
    @Singleton
    fun providesDashCoinApi(okHttpClient: OkHttpClient): PhotosApi {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PhotosApi::class.java)
    }
}