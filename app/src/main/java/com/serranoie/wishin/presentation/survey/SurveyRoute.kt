package com.serranoie.wishin.presentation.survey

import androidx.activity.ComponentActivity
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.tween
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.android.material.datepicker.MaterialDatePicker
import com.serranoie.wishin.presentation.survey.questions.PopulateBenefitsQuestion
import com.serranoie.wishin.presentation.survey.questions.PopulateCategoryQuestion
import com.serranoie.wishin.presentation.survey.questions.PopulateDisadvantages
import com.serranoie.wishin.presentation.survey.questions.PopulateNameQuestion
import com.serranoie.wishin.presentation.survey.questions.PopulateReminderQuestion
import com.serranoie.wishin.presentation.survey.questions.PopulateUsageQuestion

private const val CONTENT_ANIMATION_DURATION = 300

/**
 * Displays a [SurveyQuestionsScreen] tied to the passed [SurveyViewModel]
 */
@Composable
fun SurveyRoute(
    onSurveyComplete: () -> Unit,
) {
    val viewModel: SurveyViewModel = viewModel()
    val surveyScreenData = viewModel.surveyScreenData ?: return

    SurveyScreen(
        surveyScreenData = surveyScreenData,
        isNextEnabled = viewModel.isNextEnabled,
        onPreviousPressed = { viewModel.onPreviousPressed() },
        onNextPressed = { viewModel.onNextPressed() },
        onDonePressed = { viewModel.onDonePressed(onSurveyComplete) },
    ) { paddingValues ->

        val modifier = Modifier.padding(paddingValues).statusBarsPadding()

        AnimatedContent(
            targetState = surveyScreenData,
            transitionSpec = {
                val animationSpec: TweenSpec<IntOffset> = tween(CONTENT_ANIMATION_DURATION)

                val direction = getTransitionDirection(
                    initialIndex = initialState.questionIndex,
                    targetIndex = targetState.questionIndex,
                )

                slideIntoContainer(
                    towards = direction,
                    animationSpec = animationSpec,
                ) togetherWith slideOutOfContainer(
                    towards = direction,
                    animationSpec = animationSpec,
                )
            },
            label = "surveyScreenDataAnimation",
        ) { targetState ->

            when (targetState.surveyQuestion) {
                Questions.NAME -> PopulateNameQuestion(
                    nameItemResponse = viewModel.nameItemResponse,
                    onInputResponse = viewModel::onNameResponse,
                )

                Questions.CATEGORY -> PopulateCategoryQuestion(
                    selectedAnswer = viewModel.categoryResponse,
                    onOptionSelected = viewModel::onCategoryResponse,
                )

                Questions.USAGE -> PopulateUsageQuestion(
                    value = viewModel.usageResponse,
                    onValueChange = viewModel::onUsageResponse,
                    modifier = modifier,
                )

                Questions.BENEFITS -> PopulateBenefitsQuestion(
                    benefitsResponse = viewModel.benefitsResponse,
                    onInputResponse = viewModel::onBenefitsResponse,
                )

                Questions.CONTRAS ->
                    PopulateDisadvantages(
                        contrasResponse = viewModel.contrasResponse,
                        onInputResponse = viewModel::onContrasResponse,
                    )

                Questions.REMINDER -> {
                    PopulateReminderQuestion(
                        dateInMillis = viewModel.reminderResponse,
                        onClick = {
                            // showtimepicker
//                            showTakeawayDatePicker(
//                                date = viewModel.reminderResponse,
//                                currentActivity = currentActivity,
//                                onDateSelected = viewModel::onReminderResponse,
//                            )
                        },
                    )
                }
            }
        }
    }
}

private fun getTransitionDirection(
    initialIndex: Int,
    targetIndex: Int,
): AnimatedContentTransitionScope.SlideDirection {
    return if (targetIndex > initialIndex) {
        // Going forwards in the survey: Set the initial offset to start
        // at the size of the content so it slides in from right to left, and
        // slides out from the left of the screen to -fullWidth
        AnimatedContentTransitionScope.SlideDirection.Left
    } else {
        // Going back to the previous question in the set, we do the same
        // transition as above, but with different offsets - the inverse of
        // above, negative fullWidth to enter, and fullWidth to exit.
        AnimatedContentTransitionScope.SlideDirection.Right
    }
}

private fun showTakeawayDatePicker(
    date: Long?,
    currentActivity: ComponentActivity,
    onDateSelected: (date: Long) -> Unit,
) {
    val picker = MaterialDatePicker.Builder.datePicker()
        .setSelection(date)
        .build()
//    picker.show(currentActivity, picker.toString())
    picker.addOnPositiveButtonClickListener {
        picker.selection?.let {
            onDateSelected(it)
        }
    }
}
