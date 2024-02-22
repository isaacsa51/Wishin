package com.serranoie.wishin.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.serranoie.wishin.R
import com.serranoie.wishin.common.ScreenViewState
import com.serranoie.wishin.data.persistance.db.entity.Category
import com.serranoie.wishin.data.persistance.db.entity.Item
import com.serranoie.wishin.data.persistance.db.entity.ItemWithCategory
import com.serranoie.wishin.presentation.common.NoItemsView
import com.serranoie.wishin.presentation.navigation.Route
import com.serranoie.wishin.ui.theme.WishinTheme
import java.util.Date

@Composable
fun HomeScreen(
    navController: NavController,
    state: HomeState,
    onItemClick: (Long) -> Unit,
) {
    when (state.items) {
        is ScreenViewState.Loading -> {
            CircularProgressIndicator()
        }

        is ScreenViewState.Success -> {
            val items = state.items.data
            HomeContent(navController = navController, items = items, onItemClick = onItemClick)
        }

        is ScreenViewState.Error -> {
            Text(
                text = state.items.message ?: "Unknow Error!!",
                style = MaterialTheme.typography.displayMedium,
                color = MaterialTheme.colorScheme.error,
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeContent(
    navController: NavController,
    items: List<ItemWithCategory>,
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
                .fillMaxSize()
                .padding(padding),
        ) {
            // TODO: Via viewmodel hide or show categories with items

            if (items.isEmpty()) {
                NoItemsView()
            } else {
                LazyColumn {
                    itemsIndexed(items) { _, item ->
//                        ExpandableItem(
//                            item = item,
//                            onItemClick = onItemClick,
//                        )
                    }
                }
            }
        }
    }
}

@Preview(name = "Loaded Data")
@Composable
private fun PreviewHome() {
    val navController = rememberNavController()

    val categoriesData = listOf(
        Category(
            name = "Books",
        ),
        Category(
            name = "Clothing",
        ),
        Category(
            name = "Random",
        ),
    )

    val itemData = Item(
        name = "Name item",
        idCategory = 1,
        usage = "Sometimes",
        benefits = "Fastidii alienum nonumy detracto quaeque decore graeci dictum",
        disadvantages = "Posidonium idque et harum euismod nihil te fringilla pertinacia vulputate",
        reminderDate = Date(),
        reminderTime = Date(),
        isBought = false,
    )

    val mockData = listOf(
        ItemWithCategory(
            item = itemData,
            categories = categoriesData,
        ),
    )

    WishinTheme {
        Surface {
            HomeScreen(
                navController = navController,
                state = HomeState(items = ScreenViewState.Success(mockData)),
                onItemClick = {},
            )
        }
    }
}
