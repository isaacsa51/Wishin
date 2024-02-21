package com.serranoie.wishin.data.repositories

import com.serranoie.wishin.data.persistance.db.dao.ItemDao
import com.serranoie.wishin.data.persistance.db.entity.Item
import com.serranoie.wishin.domain.repositories.ItemRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ItemRepositoryImpl @Inject constructor(
    private val itemDao: ItemDao,
) : ItemRepository {
    override fun getAllItems(): Flow<List<Item>> {
        return itemDao.getAllItems()
    }

    override suspend fun insertItem(item: Item) {
        itemDao.insertItem(item)
    }

    override suspend fun updateItem(item: Item) {
        itemDao.updateItem(item)
    }

    override suspend fun deleteItem(id: Long) {
        itemDao.deleteItem(id)
    }
}
