package com.serranoie.wishin.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavController
import com.serranoie.wishin.R
import com.serranoie.wishin.data.persistance.db.entity.Item
import com.serranoie.wishin.presentation.common.ExpandableItem
import com.serranoie.wishin.presentation.common.NoItemsView
import com.serranoie.wishin.presentation.navigation.Route

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    state: HomeState,
    items: List<Item>,
    onItemClick: (Long) -> Unit,
) {
    Scaffold(
        modifier = Modifier.background(color = MaterialTheme.colorScheme.background),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        style = MaterialTheme.typography.headlineSmall,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                },
                actions = {
                    IconButton(onClick = { /* TODO: Navigate to Settings app */ }) {
                        Icon(
                            imageVector = Icons.Outlined.Settings,
                            contentDescription = "Application settings button",
                        )
                    }
                },
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate(Route.SurveyQuestionsScreen.route) },
            ) {
                Icon(
                    imageVector = Icons.Rounded.Add,
                    contentDescription = null,
                )
            }
        },
    ) { padding ->
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(padding),
        ) {
            // TODO: Via viewmodel hide or show categories with items

            if (items.isEmpty()) {
                NoItemsView()
            } else {
                LazyColumn {
                    itemsIndexed(items) { _, item ->
                        ExpandableItem(
                            item = item,
                            onItemClick = onItemClick,
                            navController = navController,
                        )
                    }
                }
            }
        }
    }
}

// @PreviewLightDark
// @Composable
// private fun PreviewHome() {
//    val navController = rememberNavController()
//
//    WishinTheme {
//        Surface {
//            HomeScreen(navController = navController)
//        }
//    }
// }
