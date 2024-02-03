package com.serranoie.wishin.presentation.common

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Circle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.serranoie.wishin.presentation.utils.Dimens.basePadding
import com.serranoie.wishin.presentation.utils.Dimens.largePadding
import com.serranoie.wishin.presentation.utils.Dimens.smallPadding

@Composable
fun ItemPending() {
    val context = LocalContext.current

    Row(
        modifier = Modifier
            .padding(horizontal = largePadding, vertical = basePadding)
            .fillMaxWidth()
            .clickable {
                Toast.makeText(context, "Click", Toast.LENGTH_LONG).show()
            },
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            Icons.Outlined.Circle,
            contentDescription = "Icon",
        )
        Text(
            text = "Item",
            modifier = Modifier.padding(horizontal = smallPadding),
            style = MaterialTheme.typography.titleLarge,
        )
    }
}

@Preview(showBackground = true)
@PreviewLightDark
@Composable
private fun PreviewExpandableItem() {
    Column {
        ItemPending()
    }
}
