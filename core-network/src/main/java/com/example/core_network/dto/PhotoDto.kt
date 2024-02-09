package com.example.core_network.dto

import com.example.core_domain.model.PhotoModel
import com.google.gson.annotations.SerializedName

data class PhotoDto(
    @SerializedName("albumId")
    val albumId: Int? = 0,
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("thumbnailUrl")
    val thumbnailUrl: String? = "",
    @SerializedName("title")
    val title: String? = "",
    @SerializedName("url")
    val url: String? = ""
)

fun PhotoDto.toPhotoModel(): PhotoModel {
    return PhotoModel(
        albumId = albumId ?: 0,
        id = id ?: 0,
        thumbnailUrl = thumbnailUrl ?: "",
        title = title ?: "",
        url = url ?: ""
    )
}