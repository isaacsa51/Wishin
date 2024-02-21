package com.serranoie.wishin.presentation.common

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import com.serranoie.wishin.R
import com.serranoie.wishin.ui.theme.exo2Family

@Composable
fun AlertDialogModal(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    dialogTitle: String,
    dialogText: String,
    icon: ImageVector,
) {
    val openAlertDialog = remember { mutableStateOf(false) }

    AlertDialog(
        icon = {
            Icon(icon, contentDescription = "Modal icon")
        },
        title = {
            Text(text = dialogTitle)
        },
        text = {
            Text(text = dialogText)
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation()
                },
            ) {
                Text(text = stringResource(id = R.string.confirm), fontFamily = exo2Family)
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismissRequest()
                },
            ) {
                Text(text = stringResource(id = R.string.dismiss), fontFamily = exo2Family)
            }
        },
    )
}
