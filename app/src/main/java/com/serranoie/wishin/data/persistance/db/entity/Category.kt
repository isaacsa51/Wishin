package com.serranoie.wishin.data.persistance.db.entity

import com.serranoie.wishin.R
import com.serranoie.wishin.presentation.survey.questions.Category

data class Category(
    val name: String,
)

val possibleAnswers = listOf(
    Category(R.string.category_art),
    Category(R.string.category_automotive),
    Category(R.string.category_beauty),
    Category(R.string.category_books),
    Category(R.string.category_clothing),
    Category(R.string.category_electronics),
    Category(R.string.category_gaming),
    Category(R.string.category_hobbies),
    Category(R.string.category_tools),
)
