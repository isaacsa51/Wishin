package com.serranoie.wishin.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.serranoie.wishin.presentation.home.HomeScreen
import com.serranoie.wishin.presentation.onboarding.OnBoardingScreen
import com.serranoie.wishin.presentation.onboarding.OnBoardingViewModel

@Composable
fun NavGraph(
    startDestination: String,
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route,
        ) {
            composable(
                route = Route.OnBoardingScreen.route,
            ) {
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(
                    event = viewModel::onEvent,
                )
            }
        }

        navigation(
            route = Route.HomeNavigation.route,
            startDestination = Route.HomeScreen.route,
        ) {
            composable(
                route = Route.HomeScreen.route,
            ) {
                HomeScreen()
            }
        }
    }
}
