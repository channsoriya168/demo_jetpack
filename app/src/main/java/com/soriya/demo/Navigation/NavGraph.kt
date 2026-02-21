package com.soriya.demo.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.soriya.demo.ui.screens.Navigation.HomeScreen
import com.soriya.demo.ui.screens.Navigation.SettingScreen

/**
 * Think of a NavGraph as a map of your app’s screens.
 *
 * It tells:
 *
 * What screens (destinations) exist
 *
 * Which screen is the start destination
 *
 * How to navigate between them
 *
 * What arguments a screen requires
 */
@Composable
fun NavGraph(navController: NavHostController){
    /**
     * NavHostController is a subclass of NavController.
     *
     */
    NavHost(
        navController = navController,
        startDestination = NavRoute.Home.path
    ){
        addHomeScreen(
            navController
        )
        addSettingScreen(
            navController
        )
    }
}

/**
 * So this:
 *
 * NavHost(...) {
 *     composable("home") {
 *     this bloc navGraphBuilder
 *     }
 * }
 *
 *
 * That { } block is actually a NavGraphBuilder.
 * The lambda is:
 *
 * NavGraphBuilder.() -> Unit
 *
 *
 * That means:
 *
 * Inside NavHost, you are in a NavGraphBuilder scope.
 */
fun NavGraphBuilder.addHomeScreen(navController: NavHostController) {
    composable(NavRoute.Home.path) {
        HomeScreen(
            navigateToSetting = {
                navController.navigate(NavRoute.Setting.path)
            }
        )
    }
}

fun NavGraphBuilder.addSettingScreen(navController: NavHostController) {
    composable(NavRoute.Setting.path) {
        SettingScreen(
            navigateToHome = {
                navController.navigate(NavRoute.Home.path)
            }
        ) // create a composable
    }
}

