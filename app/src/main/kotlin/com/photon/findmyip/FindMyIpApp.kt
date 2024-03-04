package com.photon.findmyip

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.photon.findmyip.navigation.AppNavHost
import com.photon.core.designsystem.theme.FindMyIPTheme

@Composable
fun FindMyIpApp() {
    FindMyIPTheme {
        val navController = rememberNavController()
        Scaffold { paddingvalues ->
            Box(
                modifier = Modifier.padding(paddingvalues)
            ) {
                AppNavHost(
                    navController = navController
                )
            }
        }
    }
}