package com.photon.feature.findmyip

import com.photon.core.model.IpData

sealed interface FindMyIpUiState {
    data object Loading: FindMyIpUiState
    data class Success(val data: IpData): FindMyIpUiState
    data class Error(val message: String?): FindMyIpUiState
}