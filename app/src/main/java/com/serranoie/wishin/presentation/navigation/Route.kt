package com.serranoie.wishin.presentation.navigation

sealed class Route(
    val route: String,
) {
    object AppStartNavigation : Route(route = "appStartNavigation")
    object HomeNavigation : Route(route = "homeNavigation")
    object OnBoardingScreen : Route(route = "onboarding_screen")
    object HomeScreen : Route(route = "home_screen")
    object SurveyQuestionsScreen : Route(route = "survey_screen")
    object FinishedSurveyScreen : Route(route = "survey_finished_screen")
}
