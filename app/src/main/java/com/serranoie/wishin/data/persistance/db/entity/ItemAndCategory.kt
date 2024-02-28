package com.serranoie.wishin.data.persistance.db.entity

import androidx.room.Entity

@Entity(primaryKeys = ["idItem", "idCategory"])
data class ItemAndCategory(
    val idItem: Long,
    val idCategory: Long,
)
