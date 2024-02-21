package com.serranoie.wishin.domain.usecases.item

import com.serranoie.wishin.data.persistance.db.entity.Item
import com.serranoie.wishin.domain.repositories.ItemRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllItemsUseCase @Inject constructor(
    private val repository: ItemRepository,
) {
    suspend operator fun invoke(): Flow<List<Item>> = repository.getAllItems()
}
