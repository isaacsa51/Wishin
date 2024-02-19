package com.serranoie.wishin.presentation.edit

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.serranoie.wishin.R
import com.serranoie.wishin.presentation.utils.Dimens
import com.serranoie.wishin.presentation.utils.Dimens.basePadding
import com.serranoie.wishin.presentation.utils.Dimens.mediumPadding
import com.serranoie.wishin.ui.theme.WishinTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditItemScreen() {
    val itemName by remember { mutableStateOf("Item Name") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Item Name",
                        style = MaterialTheme.typography.headlineSmall,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back action here */ }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                            contentDescription = "Back",
                        )
                    }
                },
            )
        },

    ) { padding ->
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(padding),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = Dimens.mediumPadding),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Box() {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Outlined.Edit, contentDescription = "Edit button")
                    }
                }

                Text(
                    text = "Category",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(
                        horizontal = Dimens.basePadding,
                        vertical = Dimens.mediumPadding,
                    ),
                )
            }

            Column(
                modifier = Modifier.padding(
                    horizontal = basePadding,
                    vertical = mediumPadding,
                ),
            ) {
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = basePadding),
                    value = itemName,
                    onValueChange = { itemName },
                    trailingIcon = { Icons.Outlined.Edit },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    maxLines = 2,
                    textStyle = MaterialTheme.typography.titleLarge,
                )

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = basePadding),
                    value = itemName,
                    onValueChange = { itemName },
                    trailingIcon = { Icons.Outlined.Edit },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    maxLines = 2,
                    textStyle = MaterialTheme.typography.titleLarge,
                )

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = basePadding),
                    value = itemName,
                    onValueChange = { itemName },
                    trailingIcon = { Icons.Outlined.Edit },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    maxLines = 2,
                    textStyle = MaterialTheme.typography.titleLarge,
                )

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = basePadding),
                    value = itemName,
                    onValueChange = { itemName },
                    trailingIcon = { Icons.Outlined.Edit },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    maxLines = 2,
                    textStyle = MaterialTheme.typography.titleLarge,
                )

                Spacer(modifier = Modifier.weight(1f))

                Row(
                    modifier = Modifier
                        .weight(1f, false),
                ) {
                    Button(
                        modifier = Modifier
                            .weight(1f)
                            .height(48.dp),
                        onClick = { /*TODO */ },
                    ) {
                        Text(text = stringResource(id = R.string.save))
                    }

                    Button(
                        modifier = Modifier
                            .weight(1f)
                            .height(48.dp),
                        onClick = { /*TODO */ },
                    ) {
                        Text(text = stringResource(id = R.string.save))
                    }
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Preview(name = "Light", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(name = "Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun EditItemPreview() {
    WishinTheme {
        Scaffold {
            EditItemScreen()
        }
    }
}
