package com.photon.findmyip.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.photon.feature.findmyip.navigation.FIND_MY_IP_ROUTE
import com.photon.feature.findmyip.navigation.findMyIpScreen

@Composable
fun AppNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = FIND_MY_IP_ROUTE
    ) {
        findMyIpScreen()
    }
}
