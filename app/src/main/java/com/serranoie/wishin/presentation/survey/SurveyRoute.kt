package com.serranoie.wishin.presentation.survey

import android.content.Context
import android.content.ContextWrapper
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.tween
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.IntOffset
import androidx.fragment.app.FragmentManager
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

        val modifier = Modifier.padding(paddingValues)

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
                Questions.NAME -> {
                    PopulateNameQuestion(
                        modifier = modifier,
                        onInputResponse = viewModel.nameItemResponse,
                    )
                }

                Questions.CATEGORY -> PopulateCategoryQuestion(
                    selectedAnswer = viewModel.categoryResponse,
                    onOptionSelected = viewModel::onCategoryResponse,
                    modifier = modifier,
                )

                Questions.USAGE -> PopulateUsageQuestion(
                    value = viewModel.usageResponse,
                    onValueChange = viewModel::onUsageResponse,
                    modifier = modifier,
                )

                Questions.BENEFITS -> {
                    PopulateBenefitsQuestion(
                        onInputResponse = viewModel.benefitsResponse,
                        modifier = modifier,
                    )
                }

                Questions.CONTRAS -> {
                    PopulateDisadvantages(
                        onInputResponse = viewModel.contrasResponse,
                        modifier = modifier,
                    )
                }

                Questions.REMINDER -> {
                    val supportFragmentManager =
                        LocalContext.current.findActivity().supportFragmentManager

                    PopulateReminderQuestion(
                        dateInMillis = viewModel.reminderResponse,
                        onClick = {
                            showTakeawayDatePicker(
                                date = viewModel.reminderResponse,
                                supportFragmentManager = supportFragmentManager,
                                onDateSelected = viewModel::onReminderResponse,
                            )
                        },
                        modifier = modifier,
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
    supportFragmentManager: FragmentManager,
    onDateSelected: (date: Long) -> Unit,
) {
    val picker = MaterialDatePicker.Builder.datePicker()
        .setSelection(date)
        .build()
    picker.show(supportFragmentManager, picker.toString())
    picker.addOnPositiveButtonClickListener {
        picker.selection?.let {
            onDateSelected(it)
        }
    }
}

private tailrec fun Context.findActivity(): AppCompatActivity =
    when (this) {
        is AppCompatActivity -> this
        is ContextWrapper -> this.baseContext.findActivity()
        else -> throw IllegalArgumentException("Could not find activity!")
    }
