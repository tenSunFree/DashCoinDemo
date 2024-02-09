package com.example.core_datasource.core

import coil.network.HttpException
import com.example.core.Resource
import com.example.core_domain.model.PhotoModel
import com.example.core_network.PhotosApi
import com.example.core_network.dto.toPhotoModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class PhotosRepositoryImpl @Inject constructor(
    private val api: PhotosApi,
) : PhotosRepository {

    override fun getPhotos(): Flow<Resource<List<PhotoModel>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = api.getPhotos().map { it.toPhotoModel() }
            emit(Resource.Success(coins))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Unexpected Error"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }
}