package com.serranoie.wishin.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.serranoie.wishin.R
import com.serranoie.wishin.presentation.utils.Dimens.smallPadding
import com.serranoie.wishin.ui.theme.WishinTheme

@Composable
fun NoItemsView() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            modifier = Modifier.fillMaxWidth().fillMaxHeight(fraction = 0.75f),
            painter = painterResource(id = R.drawable.empty_items),
            contentDescription = "Empty list image",
            contentScale = ContentScale.Fit,
        )

        Text(
            text = "No items to show",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(horizontal = 20.dp, vertical = smallPadding),
        )
    }
}

@PreviewLightDark
@Composable
private fun NoItemsPreview() {
    WishinTheme {
        Surface {
            NoItemsView()
        }
    }
}
