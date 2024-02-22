package com.serranoie.wishin.data.persistance.db.entity

import androidx.room.Embedded
import androidx.room.Relation

data class ItemWithCategory(
    @Embedded val item: Item,
    @Relation(
        parentColumn = "idCategory",
        entityColumn = "id",
    )
    val categories: List<Category>,
)
