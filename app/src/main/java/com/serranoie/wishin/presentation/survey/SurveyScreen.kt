package com.serranoie.wishin.presentation.survey

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import com.serranoie.wishin.R
import com.serranoie.wishin.presentation.common.SurveyBottomBar
import com.serranoie.wishin.presentation.common.SurveyTopBar
import com.serranoie.wishin.presentation.survey.questions.SurveyScreenData
import com.serranoie.wishin.presentation.utils.Dimens.basePadding
import com.serranoie.wishin.presentation.utils.supportWideScreen
import com.serranoie.wishin.ui.theme.WishinTheme

@Composable
fun SurveyScreen(
    surveyScreenData: SurveyScreenData,
    isNextEnabled: Boolean,
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
                    onPreviousPressed = onPreviousPressed,
                    onNextPressed = onNextPressed,
                    onDonePressed = onDonePressed,
                )
            },
        )
    }
}

@Composable
fun SurveyResultScreen(
    onDonePressed: () -> Unit,
) {
    Surface(modifier = Modifier.supportWideScreen()) {
        Scaffold(
            content = { innerPadding ->
                val modifier = Modifier.padding(innerPadding)
                SurveyResult(
                    title = stringResource(id = R.string.done_survey_title),
                    subtitle = stringResource(id = R.string.done_survey_subtitle),
                    description = stringResource(id = R.string.done_survey_description),
                    modifier = modifier,
                )
            },
            bottomBar = {
                OutlinedButton(
                    onClick = onDonePressed,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 24.dp),
                ) {
                    Text(text = stringResource(id = R.string.done))
                }
            },
        )
    }
}

@Composable
private fun SurveyResult(
    title: String,
    subtitle: String,
    description: String,
    modifier: Modifier = Modifier,
) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        item {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth(fraction = 0.8f)
                        .fillMaxHeight(fraction = 0.8f),
                    painter = painterResource(id = R.drawable.survey_reminder),
                    contentDescription = "Survey complete",
                    contentScale = ContentScale.Fit,
                )
            }

            Text(
                text = title,
                style = MaterialTheme.typography.displayLarge,
                modifier = Modifier.padding(horizontal = 20.dp),
            )
            Text(
                text = description,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(horizontal = 20.dp, vertical = basePadding),
            )
            Text(
                text = subtitle,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(horizontal = basePadding),
            )
        }
    }
}

@PreviewLightDark
@PreviewScreenSizes
@Composable
private fun PreviewSurveyResult() {
    WishinTheme {
        Surface {
            SurveyResult(
                title = stringResource(id = R.string.done_survey_title),
                subtitle = stringResource(id = R.string.done_survey_subtitle),
                description = stringResource(id = R.string.done_survey_description),
            )
        }
    }
}
