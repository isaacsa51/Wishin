package com.serranoie.wishin.domain.repositories

import com.serranoie.wishin.data.persistance.db.entity.CategoryWithItems
import com.serranoie.wishin.data.persistance.db.entity.Item
import com.serranoie.wishin.data.persistance.db.entity.ItemWithCategories
import kotlinx.coroutines.flow.Flow

interface ItemRepository {
    fun getItemsWithCategory(): Flow<List<ItemWithCategories>>
    fun getCategoryWithItems(): Flow<List<CategoryWithItems>>
    suspend fun insertItem(item: Item)
    suspend fun updateItem(item: Item)
    suspend fun deleteItem(id: Long)
}
