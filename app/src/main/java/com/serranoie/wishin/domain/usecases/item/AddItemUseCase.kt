package com.serranoie.wishin.domain.usecases.item

import com.serranoie.wishin.data.persistance.db.entity.Item
import com.serranoie.wishin.domain.repositories.ItemRepository
import javax.inject.Inject

class AddItemUseCase @Inject constructor(
    private val repository: ItemRepository,
) {
    suspend operator fun invoke(item: Item) = repository.insertItem(item)
}
