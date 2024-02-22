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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Circle
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.serranoie.wishin.data.persistance.db.entity.Category
import com.serranoie.wishin.data.persistance.db.entity.Item
import com.serranoie.wishin.data.persistance.db.entity.ItemWithCategory
import com.serranoie.wishin.presentation.utils.Dimens
import com.serranoie.wishin.presentation.utils.Dimens.basePadding
import com.serranoie.wishin.presentation.utils.Dimens.largePadding
import com.serranoie.wishin.presentation.utils.Dimens.mediumPadding
import com.serranoie.wishin.ui.theme.WishinTheme
import java.util.Date

@Composable
fun ExpandableItem(
    titleCategory: Category,
    item: ItemWithCategory,
    onItemClick: (Long) -> Unit,
) {
    var expanded by remember { mutableStateOf(true) }
    val isBought = item.item.isBought

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
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = mediumPadding),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .clip(RoundedCornerShape(6.dp))
                        .background(MaterialTheme.colorScheme.secondary),
                )

                Text(
                    text = titleCategory.name,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(horizontal = basePadding, vertical = mediumPadding),
                )
            }

            if (expanded) {
                // TODO: Add each item in and check the status of the current item

//                if (isBought) {
//                    PurchasedItem(
// //                        navController = navController,
//                        item = item,
//                        onItemClick = onItemClick,
//                    )
//                } else {
//                    PendingItem(
// //                        navController = navController,
//                        item = item,
//                        onItemClick = onItemClick,
//                    )
//                }
            }
        }
    }
}

@Composable
fun PurchasedItem(item: Item, onItemClick: (Long) -> Unit) {
    Row(
        modifier = Modifier
            .padding(horizontal = largePadding)
            .fillMaxWidth()
            .height(48.dp)
            .clickable {
                // navController.navigate(Route.EditScreen.route)
                onItemClick(item.id)
            },
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            Icons.Rounded.Check,
            contentDescription = "Check icon",
        )
        Text(
            text = item.name,
            modifier = Modifier.padding(horizontal = Dimens.smallPadding),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.titleLarge,
            textDecoration = TextDecoration.LineThrough,
        )
    }
}

@Composable
fun PendingItem(item: Item, onItemClick: (Long) -> Unit) {
    Row(
        modifier = Modifier
            .padding(horizontal = largePadding, vertical = basePadding)
            .fillMaxWidth()
            .height(48.dp)
            .clickable {
                // navController.navigate(Route.EditScreen.route)
                onItemClick(item.id)
            },
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            Icons.Outlined.Circle,
            contentDescription = "Icon",
        )
        Text(
            text = item.name,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(horizontal = Dimens.smallPadding),
            style = MaterialTheme.typography.titleLarge,
        )
    }
}

@PreviewLightDark
@Composable
private fun PreviewExpandableItem() {
    val category1 = Category(name = "Books")
    val category2 = Category(name = "Clothing")

    val categoriesData = listOf(
        Category(
            name = "Books",
        ),
        Category(
            name = "Clothing",
        ),
        Category(
            name = "Random",
        ),
    )

    val itemData = Item(
        name = "Name item",
        idCategory = 1,
        usage = "Sometimes",
        benefits = "Fastidii alienum nonumy detracto quaeque decore graeci dictum",
        disadvantages = "Posidonium idque et harum euismod nihil te fringilla pertinacia vulputate",
        reminderDate = Date(),
        reminderTime = Date(),
        isBought = false,
    )

    val mockData = ItemWithCategory(
        item = itemData,
        categories = categoriesData,
    )

    WishinTheme {
        Surface {
            Column {
                ExpandableItem(titleCategory = category1, item = mockData, onItemClick = {})
                ExpandableItem(titleCategory = category2, item = mockData, onItemClick = {})
            }
        }
    }
}
