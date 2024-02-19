package com.serranoie.wishin.presentation.navigation

import androidx.appcompat.view.menu.ActionMenuItem
import androidx.compose.ui.graphics.vector.ImageVector

sealed interface Screen {
    val route: String
    val isAppBarVisible: Boolean
    val navigationIcon: ImageVector?
    val navigationIconContentDescription: String?
    val onNavigationIconClick: (() -> Unit)?
    val title: String
    val actions: List<ActionMenuItem>
}
