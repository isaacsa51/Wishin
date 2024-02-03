package com.serranoie.wishin.presentation.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import com.serranoie.wishin.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MediumAppBar(scrollBehavior: TopAppBarScrollBehavior) {
    MediumTopAppBar(
//        colors = TopAppBarDefaults.mediumTopAppBarColors(
//            scrolledContainerColor = MaterialTheme.colorScheme.primary,
//        ),
        title = {
            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.headlineMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        },
        actions = {
            IconButton(onClick = { /* TODO: Navigate to settings app */ }) {
                Icon(
                    imageVector = Icons.Outlined.Settings,
                    contentDescription = "Application settings button",
                )
            }
        },
        scrollBehavior = scrollBehavior,
    )
}
