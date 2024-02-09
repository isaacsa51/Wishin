package com.serranoie.wishin.presentation.survey.questions

import android.content.res.Configuration
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.serranoie.wishin.R
import com.serranoie.wishin.presentation.survey.QuestionWrapper
import com.serranoie.wishin.presentation.utils.Dimens.basePadding
import com.serranoie.wishin.ui.theme.WishinTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NameItemQuestion(
    @StringRes titleResourceId: Int,
    @StringRes directionsResourceId: Int,
    onInputResponse: (String) -> Unit,
    nameItemResponse: String,
    modifier: Modifier = Modifier,
) {
    QuestionWrapper(
        titleResourceId = titleResourceId,
        directionsResourceId = directionsResourceId,
        modifier = Modifier,
    ) {
        Column(
            modifier = modifier
                .padding(basePadding),
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                value = nameItemResponse,
                onValueChange = onInputResponse,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                maxLines = 2,
                textStyle = MaterialTheme.typography.headlineMedium,
            )
        }
    }
}

@Composable
fun PopulateNameQuestion(
    onInputResponse: (String) -> Unit,
    nameItemResponse: String,
) {
    NameItemQuestion(
        titleResourceId = R.string.name_question,
        directionsResourceId = R.string.name_helper,
        onInputResponse = onInputResponse,
        nameItemResponse = nameItemResponse,
    )
}

@Preview(name = "Light", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(name = "Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun NameItemQuestionPreview() {
    WishinTheme {
        Surface {
            var onInputResponse by remember { mutableStateOf("") }

            NameItemQuestion(
                titleResourceId = R.string.name_question,
                directionsResourceId = R.string.name_helper,
                onInputResponse = { onInputResponse },
                nameItemResponse = "",
            )
        }
    }
}
