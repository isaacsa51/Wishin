package com.serranoie.wishin.presentation.survey.questions

import android.content.res.Configuration
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.serranoie.wishin.R
import com.serranoie.wishin.presentation.survey.QuestionWrapper
import com.serranoie.wishin.presentation.survey.simpleDateFormatPattern
import com.serranoie.wishin.presentation.utils.getDefaultDateInMillis
import com.serranoie.wishin.ui.theme.WishinTheme
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReminderQuestion(
    @StringRes titleResourceId: Int,
    @StringRes directionsResourceId: Int,
    dateInMillis: Long?,
) {
    QuestionWrapper(
        titleResourceId = titleResourceId,
        directionsResourceId = directionsResourceId,
    ) {
        val dateFormat = SimpleDateFormat(simpleDateFormatPattern, Locale.getDefault())
        dateFormat.timeZone = TimeZone.getTimeZone("UTC")
        val dateString = dateFormat.format(dateInMillis ?: getDefaultDateInMillis())

        val datePickerState = rememberDatePickerState()
        var showDatePicker by remember { mutableStateOf(false) }

        val timePickerState = rememberTimePickerState()
        var showTimePicker by remember { mutableStateOf(false) }

        Row(
            modifier = Modifier
                .padding(vertical = 20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
        ) {
            Button(
                onClick = { showDatePicker = true },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    contentColor = MaterialTheme.colorScheme.onSurface,
                ),
                shape = MaterialTheme.shapes.small,
                border = BorderStroke(
                    1.dp,
                    MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
                ),
            ) {
                Text(
                    text = dateString,
                    style = MaterialTheme.typography.bodyLarge,
                )
            }

            Button(
                onClick = { showTimePicker = true },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    contentColor = MaterialTheme.colorScheme.onSurface,
                ),
                shape = MaterialTheme.shapes.small,
                border = BorderStroke(
                    1.dp,
                    MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
                ),
            ) {
                Text(
                    text = "Select time",
                    style = MaterialTheme.typography.bodyLarge,
                )
            }
        }

        if (showDatePicker) {
            DatePickerDialog(
                onDismissRequest = { /*TODO*/ },
                confirmButton = {
                    TextButton(
                        onClick = {
                            showDatePicker = false
                        },
                    ) { Text("OK") }
                },
                dismissButton = {
                    TextButton(
                        onClick = {
                            showDatePicker = false
                        },
                    ) { Text("Cancel") }
                },
            ) {
                DatePicker(state = datePickerState)
            }
        }

        if (showTimePicker) {
            TimePickerDialog(
                onDismissRequest = { /*TODO*/ },
                confirmButton = {
                    TextButton(
                        onClick = {
                            showTimePicker = false
                        },
                    ) { Text("OK") }
                },
                dismissButton = {
                    TextButton(
                        onClick = {
                            showTimePicker = false
                        },
                    ) { Text("Cancel") }
                },
            ) {
                TimePicker(state = timePickerState)
            }
        }
    }
}

@Composable
fun PopulateReminderQuestion(
    dateInMillis: Long?,
    onClick: () -> Unit,
) {
    ReminderQuestion(
        titleResourceId = R.string.reminder_question,
        directionsResourceId = R.string.select_date,
        dateInMillis = dateInMillis,
    )
}

@Composable
fun TimePickerDialog(
    title: String = "Select Time",
    onDismissRequest: () -> Unit,
    confirmButton: @Composable (() -> Unit),
    dismissButton: @Composable (() -> Unit)? = null,
    content: @Composable () -> Unit,
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(
            usePlatformDefaultWidth = false,
        ),
    ) {
        Surface(
            shape = MaterialTheme.shapes.extraLarge,
            tonalElevation = 6.dp,
            modifier = Modifier
                .width(IntrinsicSize.Min)
                .height(IntrinsicSize.Min)
                .background(
                    shape = MaterialTheme.shapes.extraLarge,
                    color = containerColor,
                ),
            color = containerColor,
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 20.dp),
                    text = title,
                    style = MaterialTheme.typography.labelMedium,
                )
                content()
                Row(
                    modifier = Modifier
                        .height(40.dp)
                        .fillMaxWidth(),
                ) {
                    Spacer(modifier = Modifier.weight(1f))
                    dismissButton?.invoke()
                    confirmButton()
                }
            }
        }
    }
}

@Preview(name = "Light", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(name = "Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun ReminderPreview() {
    WishinTheme {
        Surface {
            ReminderQuestion(
                titleResourceId = R.string.reminder_question,
                directionsResourceId = R.string.select_date,
                dateInMillis = 1732083180000, // 2024-11-20
            )
        }
    }
}
