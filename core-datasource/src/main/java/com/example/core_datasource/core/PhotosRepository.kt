package com.example.core_datasource.core

import com.example.core.Resource
import com.example.core_domain.model.PhotoModel
import kotlinx.coroutines.flow.Flow

interface PhotosRepository {

    fun getPhotos(): Flow<Resource<List<PhotoModel>>>
}