package com.serranoie.wishin.data.persistance.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories")
data class Category(
    @PrimaryKey(autoGenerate = true)
    val idCategory: Long = 0,
    val name: String,
)
