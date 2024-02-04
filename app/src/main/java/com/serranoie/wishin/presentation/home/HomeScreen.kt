package com.serranoie.wishin.presentation.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.serranoie.wishin.presentation.common.ExpandableItem
import com.serranoie.wishin.presentation.navigation.Route

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    paddingValues: PaddingValues,
) {
    Scaffold(
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
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(paddingValues)
                .statusBarsPadding(),
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
