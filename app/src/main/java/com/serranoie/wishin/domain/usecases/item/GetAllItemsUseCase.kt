package com.serranoie.wishin.domain.usecases.item

import com.serranoie.wishin.data.persistance.db.entity.ItemWithCategory
import com.serranoie.wishin.domain.repositories.ItemRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllItemsUseCase @Inject constructor(
    private val repository: ItemRepository,
) {
    operator fun invoke(): Flow<List<ItemWithCategory>> = repository.getItemsWithCategories()
}
