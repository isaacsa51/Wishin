package com.serranoie.wishin.domain.usecases.item

import com.serranoie.wishin.data.persistance.db.entity.CategoryWithItems
import com.serranoie.wishin.domain.repositories.ItemRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllItemsWithCategoryUseCase @Inject constructor(
    private val repository: ItemRepository,
) {
    operator fun invoke(): Flow<List<CategoryWithItems>> = repository.getCategoryWithItems()
}
