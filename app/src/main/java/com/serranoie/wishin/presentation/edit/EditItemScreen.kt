package com.serranoie.wishin.presentation.edit

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.serranoie.wishin.R
import com.serranoie.wishin.presentation.utils.Dimens
import com.serranoie.wishin.presentation.utils.Dimens.basePadding
import com.serranoie.wishin.presentation.utils.Dimens.extraSmallPadding
import com.serranoie.wishin.presentation.utils.Dimens.mediumPadding
import com.serranoie.wishin.presentation.utils.Dimens.smallPadding
import com.serranoie.wishin.ui.theme.WishinTheme
import com.serranoie.wishin.ui.theme.exo2Family

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditItemScreen(navController: NavController) {
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
                    IconButton(onClick = { navController.popBackStack() }) {
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
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(padding),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = Dimens.mediumPadding),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Box(
                    modifier = Modifier.background(
                        MaterialTheme.colorScheme.primaryContainer,
                        shape = MaterialTheme.shapes.medium,
                    ),
                ) {
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
                        vertical = Dimens.basePadding,
                    ),
                )
            }

            Column(
                modifier = Modifier.padding(
                    horizontal = basePadding,
                    vertical = mediumPadding,
                ),
            ) {
                Text(
                    text = stringResource(R.string.item_details),
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier
                        .padding(vertical = smallPadding)
                        .fillMaxWidth(),
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

                OutlinedCard(
                    modifier = Modifier.fillMaxWidth()
                        .padding(vertical = basePadding)
                        .clickable {
                            // TODO: Display modal dialog
                        },
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface,
                    ),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
                    shape = RoundedCornerShape(5.dp),
                ) {
                    Text(
                        text = stringResource(id = R.string.usage_button_label) + " " + stringResource(
                            R.string.usage_very_often,
                        ),
                        modifier = Modifier.padding(
                            horizontal = basePadding,
                            vertical = basePadding,
                        ),
                        fontSize = 22.sp,
                    )
                }

                Text(
                    text = stringResource(R.string.benefits_label),
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier
                        .padding(vertical = extraSmallPadding)
                        .fillMaxWidth(),
                )

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(220.dp)
                        .padding(vertical = smallPadding),
                    value = itemName,
                    onValueChange = { itemName },
                    trailingIcon = { Icons.Outlined.Edit },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    maxLines = 5,
                    textStyle = MaterialTheme.typography.bodyLarge,
                )

                Text(
                    text = stringResource(R.string.disadvantages_label),
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier
                        .padding(vertical = extraSmallPadding)
                        .fillMaxWidth(),
                )

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(220.dp)
                        .padding(vertical = smallPadding),
                    value = itemName,
                    onValueChange = { itemName },
                    trailingIcon = { Icons.Outlined.Edit },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    maxLines = 5,
                    textStyle = MaterialTheme.typography.bodyLarge,
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

                OutlinedCard(
                    modifier = Modifier.fillMaxWidth()
                        .padding(vertical = basePadding)
                        .clickable {
                            // TODO: Display modal dialog
                        },
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface,
                    ),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
                    shape = RoundedCornerShape(5.dp),
                ) {
                    Text(
                        text = stringResource(id = R.string.reminder_set_label) + " 19/11/2025",
                        modifier = Modifier.padding(
                            horizontal = basePadding,
                            vertical = basePadding,
                        ),
                        fontSize = 22.sp,
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                Row(
                    modifier = Modifier.fillMaxWidth().padding(vertical = basePadding),
                ) {
                    OutlinedButton(
                        modifier = Modifier
                            .weight(1f)
                            .height(48.dp)
                            .padding(horizontal = smallPadding),
                        onClick = { navController.popBackStack() },
                    ) {
                        Text(text = stringResource(id = R.string.cancel), fontFamily = exo2Family)
                    }

                    Button(
                        modifier = Modifier
                            .weight(1f)
                            .height(48.dp)
                            .padding(horizontal = smallPadding),
                        onClick = {
                            // TODO: Handle in viewmodel changes on textinputs
                            navController.popBackStack()
                        },
                    ) {
                        Text(text = stringResource(id = R.string.save), fontFamily = exo2Family)
                    }
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(name = "Light", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun EditItemPreview() {
    val navController = rememberNavController()

    WishinTheme {
        Scaffold {
            EditItemScreen(navController)
        }
    }
}
