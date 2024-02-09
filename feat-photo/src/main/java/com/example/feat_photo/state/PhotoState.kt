package com.example.feat_photo.state

import com.example.core_domain.model.PhotoModel

data class PhotoState(
    val isLoading: Boolean = false,
    val coins: List<PhotoModel> = emptyList(),
    val error: String = ""
)
