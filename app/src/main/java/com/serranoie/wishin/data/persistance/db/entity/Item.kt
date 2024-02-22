package com.serranoie.wishin.data.persistance.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "items")
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val idCategory: Long,
    val name: String,
    val usage: String,
    val benefits: String?,
    val disadvantages: String,
    val reminderDate: Date,
    val reminderTime: Date,
    val isBought: Boolean = false,
)
