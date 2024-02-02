package com.serranoie.wishin

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.serranoie.wishin.domain.usecases.appentry.AppEntryUseCase
import com.serranoie.wishin.presentation.navigation.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val appEntryUseCase: AppEntryUseCase,
) : ViewModel() {
    var splashCondition by mutableStateOf(true)

    var startDestination by mutableStateOf(Route.AppStartNavigation.route)
        private set

    init {
        appEntryUseCase.readAppEntry().onEach { shouldStartFromHome ->
            if (shouldStartFromHome) {
                startDestination = Route.HomeNavigation.route
            } else {
                startDestination = Route.AppStartNavigation.route
            }
            delay(500)
            splashCondition = false
        }.launchIn(viewModelScope)
    }
}
