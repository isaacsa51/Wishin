package com.serranoie.wishin.presentation.survey.questions

import android.content.res.Configuration
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.serranoie.wishin.R
import com.serranoie.wishin.presentation.survey.QuestionWrapper
import com.serranoie.wishin.presentation.utils.Dimens
import com.serranoie.wishin.presentation.utils.Dimens.basePadding
import com.serranoie.wishin.ui.theme.WishinTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DisadvantagesQuestion(
    @StringRes titleResourceId: Int,
    @StringRes directionsResourceId: Int,
    onInputResponse: (String) -> Unit,
    contrasResponse: String,
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
                .padding(basePadding),
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp),
                value = contrasResponse,
                onValueChange = onInputResponse,
                maxLines = 5,
                textStyle = MaterialTheme.typography.bodyLarge,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            )
        }
    }
}

@Composable
fun PopulateDisadvantages(
    modifier: Modifier = Modifier,
    onInputResponse: (String) -> Unit,
    contrasResponse: String,
) {
    DisadvantagesQuestion(
        titleResourceId = R.string.cons_question,
        directionsResourceId = R.string.reasons_helper,
        onInputResponse = onInputResponse,
        contrasResponse = contrasResponse,
        modifier = modifier,
    )
}

@Preview(name = "Light", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(name = "Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DisadvantagesPreview() {
    WishinTheme {
        Surface {
            var onInputResponse by remember { mutableStateOf("") }

            DisadvantagesQuestion(
                titleResourceId = R.string.cons_question,
                directionsResourceId = R.string.reasons_helper,
                onInputResponse = { onInputResponse },
                contrasResponse = "",
            )
        }
    }
}
