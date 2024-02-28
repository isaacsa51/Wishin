package com.serranoie.wishin.presentation.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.serranoie.wishin.data.persistance.db.entity.Category
import com.serranoie.wishin.data.persistance.db.entity.CategoryWithItems
import com.serranoie.wishin.data.persistance.db.entity.Item
import com.serranoie.wishin.presentation.common.ExpandableItem
import com.serranoie.wishin.ui.theme.WishinTheme
import java.util.Date

@Composable
fun CategoriesCard(
    item: CategoryWithItems,
    onItemClick: (Long) -> Unit,
) {
    LazyColumn {
        items(item.items.size) {
            if (item.items.isNotEmpty()) {
                ExpandableItem(
                    titleCategory = item.category,
                    itemIndex = it,
                    item = item,
                    onItemClick = onItemClick,
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun PreviewCategoriesCard() {
    val categoriesData = Category(
        name = "Art",
    )

    val itemData = listOf(
        Item(
            name = "Name item",
            usage = "Sometimes",
            benefits = "Fastidii alienum nonumy detracto quaeque decore graeci dictum",
            disadvantages = "Posidonium idque et harum euismod nihil te fringilla pertinacia vulputate",
            reminderDate = Date(),
            reminderTime = Date(),
            isBought = false,
        ),
        Item(
            name = "Name item",
            usage = "Sometimes",
            benefits = "Fastidii alienum nonumy detracto quaeque decore graeci dictum",
            disadvantages = "Posidonium idque et harum euismod nihil te fringilla pertinacia vulputate",
            reminderDate = Date(),
            reminderTime = Date(),
            isBought = true,
        ),
    )

    val mockData = CategoryWithItems(
        category = categoriesData,
        items = itemData,
    )

    WishinTheme {
        Surface {
            CategoriesCard(item = mockData, onItemClick = {})
        }
    }
}
