package com.example.feat_photo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.Resource
import com.example.core_datasource.core.PhotosRepository
import com.example.core_domain.model.PhotoModel
import com.example.feat_photo.state.PhotoState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotoViewModel @Inject constructor(
    private val photosRepository: PhotosRepository,
) : ViewModel() {

    private val _state = MutableStateFlow(PhotoState())
    val state = _state.asStateFlow()

    init {
        if (_state.value.coins.isEmpty()) {
            getPhotos()
        }
    }

    private fun getPhotos() {
        viewModelScope.launch(Dispatchers.IO) {
            photosRepository.getPhotos()
                .distinctUntilChanged()
                .collectLatest { result ->
                    when (result) {
                        is Resource.Success -> result.data?.let { data -> onRequestSuccess(data) }
                        is Resource.Error -> onRequestError(result.message)
                        is Resource.Loading -> onRequestLoading()
                        else -> Unit
                    }
                }
        }
    }

    private fun onRequestSuccess(
        data: List<PhotoModel>
    ) {
        _state.update {
            it.copy(
                coins = it.coins + data,
                isLoading = false,
                error = ""
            )
        }
    }

    private fun onRequestError(
        message: String?
    ) {
        _state.update {
            it.copy(
                error = message ?: "Unexpected Error",
                isLoading = false,
            )
        }
    }

    private fun onRequestLoading() {
        if (_state.value.coins.isEmpty()) {
            _state.update {
                it.copy(
                    isLoading = true
                )
            }
        }
    }
}