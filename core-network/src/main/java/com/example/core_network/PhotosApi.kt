package com.example.core_network

import com.example.core_network.dto.PhotoDto
import retrofit2.http.GET

interface PhotosApi {

    @GET("/photos")
    suspend fun getPhotos(): List<PhotoDto>
}