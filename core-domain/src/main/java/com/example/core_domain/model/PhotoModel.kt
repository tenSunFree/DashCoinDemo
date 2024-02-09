package com.example.core_domain.model

data class PhotoModel(
    val albumId: Int? = 0,
    val id: Int? = 0,
    val thumbnailUrl: String? = "",
    val title: String? = "",
    val url: String? = ""
)