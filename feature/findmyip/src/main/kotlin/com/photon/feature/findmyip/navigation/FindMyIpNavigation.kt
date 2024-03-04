package com.photon.feature.findmyip.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.photon.feature.findmyip.FindMyIpRoute


const val FIND_MY_IP_ROUTE = "findmyip"
fun NavController.navigateToFindMyIp(
    navOptions: NavOptions
) = navigate(route = FIND_MY_IP_ROUTE, navOptions = navOptions)

fun NavGraphBuilder.findMyIpScreen(){
    composable(route = FIND_MY_IP_ROUTE){
        FindMyIpRoute()
    }
}