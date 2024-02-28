package com.serranoie.wishin.data.persistance.db.entity

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class CategoryWithItems(
    @Embedded
    val category: Category,

    @Relation(
        parentColumn = "idCategory",
        entityColumn = "idItem",
        associateBy = Junction(
            value = ItemAndCategory::class,
            parentColumn = "idCategory",
            entityColumn = "idItem",
        ),
    )
    val items: List<Item>,
)
