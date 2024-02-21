package com.serranoie.wishin.domain.repositories

import com.serranoie.wishin.data.persistance.db.entity.Item
import kotlinx.coroutines.flow.Flow

interface ItemRepository {
    fun getAllItems(): Flow<List<Item>>
    suspend fun insertItem(item: Item)
    suspend fun updateItem(item: Item)
    suspend fun deleteItem(id: Long)
}
