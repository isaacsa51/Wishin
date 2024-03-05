package com.serranoie.wishin.data.repositories

import com.serranoie.wishin.data.persistance.db.dao.ItemDao
import com.serranoie.wishin.data.persistance.db.entity.CategoryWithItems
import com.serranoie.wishin.data.persistance.db.entity.Item
import com.serranoie.wishin.data.persistance.db.entity.ItemWithCategories
import com.serranoie.wishin.domain.repositories.ItemRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ItemRepositoryImpl @Inject constructor(
    private val itemDao: ItemDao,
) : ItemRepository {
    override fun getItemById(id: Long): Flow<Item> {
        return itemDao.getItemById(id)
    }

    override fun getItemsWithCategory(): Flow<List<ItemWithCategories>> {
        return itemDao.getItemsWithCategories()
    }

    override fun getCategoryWithItems(): Flow<List<CategoryWithItems>> {
        return itemDao.getCategoryWithItems()
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
