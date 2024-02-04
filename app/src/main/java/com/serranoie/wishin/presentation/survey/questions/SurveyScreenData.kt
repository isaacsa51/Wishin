package com.serranoie.wishin.presentation.survey.questions

import com.serranoie.wishin.presentation.survey.Questions

data class SurveyScreenData(
    val questionIndex: Int,
    val questionCount: Int,
    val shouldShowPreviousButton: Boolean,
    val shouldShowDoneButton: Boolean,
    val surveyQuestion: Questions,
)
