package com.serranoie.wishin.presentation.common

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.serranoie.wishin.presentation.utils.Dimens.basePadding
import com.serranoie.wishin.presentation.utils.Dimens.mediumPadding

@Composable
fun ExpandableItem() {
    var expanded by remember { mutableStateOf(false) }

    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(basePadding)
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing,
                ),
            )
            .clickable {
                expanded = !expanded
            },
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = mediumPadding),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Box(
                    modifier = Modifier.size(24.dp).clip(RoundedCornerShape(6.dp))
                        .background(MaterialTheme.colorScheme.tertiary),
                )

                Text(
                    text = "Category",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(horizontal = basePadding, vertical = mediumPadding),
                )
            }

            if (expanded) {
                ItemPending()
                ItemPending()
                ItemDone()
            }
        }
    }
}

@Preview(showBackground = true)
@PreviewLightDark
@Composable
private fun PreviewExpandableItem() {
    ExpandableItem()
}
