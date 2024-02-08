package com.serranoie.wishin.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.serranoie.wishin.presentation.common.ExpandableItem
import com.serranoie.wishin.presentation.common.MediumAppBar
import com.serranoie.wishin.presentation.navigation.Route

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
) {
    Scaffold(
        modifier = Modifier.background(color = MaterialTheme.colorScheme.background),
        topBar = {
            MediumAppBar()
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
            ExpandableItem()
            ExpandableItem()
            ExpandableItem()
            ExpandableItem()
            ExpandableItem()
            ExpandableItem()
            ExpandableItem()
        }
//        LazyColumn(modifier = Modifier.padding(paddingValues).statusBarsPadding().fillMaxSize()) {
//            ExpandableItem()
//            ExpandableItem()
//            ExpandableItem()
//            ExpandableItem()
//        }
    }
}
