package com.serranoie.wishin.presentation.home

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.serranoie.wishin.data.persistance.db.entity.Category
import com.serranoie.wishin.data.persistance.db.entity.Item
import com.serranoie.wishin.data.persistance.db.entity.ItemWithCategory
import com.serranoie.wishin.presentation.common.ExpandableItem
import com.serranoie.wishin.ui.theme.WishinTheme
import java.util.Date

@Composable
fun CategoriesCard(
    item: ItemWithCategory,
    onItemClick: (Long) -> Unit,
) {
    item.categories.forEach { category ->
        if (item.item.name.isNotEmpty()) {
            ExpandableItem(titleCategory = category, item = item, onItemClick = onItemClick)
        }
    }

//    possileAnswers.forEach { currentCategory ->
//        // Handle if the category is empty don't show it on the screen
//        if (item.name.isNotEmpty()) {
//            ExpandableItem(titleCategory = currentCategory, item = item, onItemClick = onItemClick)
//        }
//    }
}

@PreviewLightDark
@Composable
private fun PreviewCategoriesCard() {
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
            CategoriesCard(item = mockData, onItemClick = {})
        }
    }
}
