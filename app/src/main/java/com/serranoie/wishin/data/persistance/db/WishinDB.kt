package com.serranoie.wishin.data.persistance.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.serranoie.wishin.data.persistance.converters.DateConverter
import com.serranoie.wishin.data.persistance.db.dao.ItemDao
import com.serranoie.wishin.data.persistance.db.entity.Category
import com.serranoie.wishin.data.persistance.db.entity.Item
import com.serranoie.wishin.data.persistance.db.entity.ItemAndCategory

@TypeConverters(value = [DateConverter::class])
@Database(
    entities = [
        Item::class,
        Category::class,
        ItemAndCategory::class,
    ],
    version = 2,
    exportSchema = false,
)
abstract class WishinDB : RoomDatabase() {
    abstract val itemDao: ItemDao
}
