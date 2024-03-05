package com.photon.feature.findmyip

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.photon.core.common.Result
import com.photon.core.data.FindMyIpRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class FindMyIpViewModel @Inject constructor(
    repository: FindMyIpRepository
) : ViewModel() {
    var findMyIpUiState: StateFlow<FindMyIpUiState> = repository
        .findMyIp()
        .map {
            return@map when(it){
                is Result.Success -> {
                    FindMyIpUiState.Success(data = it.data!!)
                }

                is Result.Error -> {
                    FindMyIpUiState.Error(message = it.message)
                }
            }
        }
        .stateIn(
            scope = viewModelScope,
            initialValue = FindMyIpUiState.Loading,
            started = SharingStarted.WhileSubscribed(5_000)
        )
}