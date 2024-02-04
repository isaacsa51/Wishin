package com.serranoie.wishin.presentation.survey.questions

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CategoryQuestion(
    @StringRes titleResourceId: Int,
    @StringRes directionsResourceId: Int,
    possibleAnswers: List<Category>,
    selectedAnswer: Category?,
    onOptionSelected: (Category) -> Unit,
    modifier: Modifier = Modifier,
) {
}

data class Category(val name: String)
