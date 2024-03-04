package com.photon.feature.findmyip

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun FindMyIpRoute() {
    FindMyIpScreen()
}

@Composable
internal fun FindMyIpScreen(
    viewModel: FindMyIpViewModel = hiltViewModel()
) {
    Surface(
        color = MaterialTheme.colorScheme.surface
    ) {
        TopAppBar()
    }
}

@Composable
fun TopAppBar() {
    Row {
        Text(
            text = "Photon"
        )
    }
}