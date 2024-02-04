package com.serranoie.wishin.presentation.survey.questions

import android.content.res.Configuration
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.serranoie.wishin.R
import com.serranoie.wishin.presentation.common.AutoSizeTextField
import com.serranoie.wishin.presentation.survey.QuestionWrapper
import com.serranoie.wishin.ui.theme.WishinTheme

@Composable
fun NameItemQuestion(
    @StringRes titleResourceId: Int,
    @StringRes directionsResourceId: Int,
    onInputResponse: String?,
    modifier: Modifier = Modifier,
) {
    var text by rememberSaveable { mutableStateOf("") }

    QuestionWrapper(
        titleResourceId = titleResourceId,
        directionsResourceId = directionsResourceId,
        modifier = Modifier,
    ) {
        Column(
            modifier = modifier
                .padding(horizontal = 16.dp),
        ) {
            AutoSizeTextField(
                value = text,
                onValueChange = { onInputResponse },
                maxLines = 2,
                minFontSize = 10.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),
            )

            Spacer(Modifier.height(18.dp))
        }
    }
}

@Composable
fun PopulateNameQuestion(
    modifier: Modifier = Modifier,
    onInputResponse: String?,
) {
    NameItemQuestion(
        titleResourceId = R.string.name_question,
        directionsResourceId = R.string.name_helper,
        onInputResponse = onInputResponse,
        modifier = modifier,
    )
}

@Preview(name = "Light", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(name = "Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun NameItemQuestionPreview() {
    WishinTheme {
        Surface {
            NameItemQuestion(
                titleResourceId = R.string.name_question,
                directionsResourceId = R.string.name_helper,
                onInputResponse = null,
            )
        }
    }
}
