package com.serranoie.wishin.presentation.survey

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.serranoie.wishin.presentation.common.SurveyBottomBar
import com.serranoie.wishin.presentation.common.SurveyTopBar
import com.serranoie.wishin.presentation.survey.questions.SurveyScreenData
import com.serranoie.wishin.presentation.utils.supportWideScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SurveyScreen(
    surveyScreenData: SurveyScreenData,
    isNextEnabled: Boolean,
    onClosePressed: () -> Unit,
    onPreviousPressed: () -> Unit,
    onNextPressed: () -> Unit,
    onDonePressed: () -> Unit,
    content: @Composable (PaddingValues) -> Unit,
) {
    Surface(modifier = Modifier.supportWideScreen()) {
        Scaffold(
            topBar = {
                SurveyTopBar(
                    questionIndex = surveyScreenData.questionIndex,
                    totalQuestionsCount = surveyScreenData.questionCount,
                )
            },
            content = content,
            bottomBar = {
                SurveyBottomBar(
                    shouldShowPreviousButton = surveyScreenData.shouldShowPreviousButton,
                    shouldShowDoneButton = surveyScreenData.shouldShowDoneButton,
                    isNextButtonEnabled = isNextEnabled,
//                    onPreviousPressed = onPreviousPressed,
//                    onNextPressed = onNextPressed,
//                    onDonePressed = onDonePressed,
                )
            },
        )
    }
}
