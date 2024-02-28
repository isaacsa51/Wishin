package com.serranoie.wishin.data.persistance.db.entity

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class ItemWithCategories(
    @Embedded
    val item: Item,

    @Relation(
        parentColumn = "idItem",
        entityColumn = "idCategory",
        associateBy = Junction(
            value = ItemAndCategory::class,
            parentColumn = "idItem",
            entityColumn = "idCategory",
        ),
    )
    val categories: List<Category>,
)
