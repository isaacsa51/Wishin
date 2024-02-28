package com.serranoie.wishin.data.persistance.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.serranoie.wishin.data.persistance.db.entity.CategoryWithItems
import com.serranoie.wishin.data.persistance.db.entity.Item
import com.serranoie.wishin.data.persistance.db.entity.ItemWithCategories
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {
    @Query("SELECT * FROM items")
    fun getItemsWithCategories(): Flow<List<ItemWithCategories>>

    @Query("SELECT * FROM categories")
    fun getCategoryWithItems(): Flow<List<CategoryWithItems>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: Item)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateItem(item: Item)

    @Query("DELETE FROM items WHERE idItem=:id")
    suspend fun deleteItem(id: Long)
}
