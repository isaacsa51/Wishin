package com.serranoie.wishin.domain.usecases.item

import com.serranoie.wishin.data.persistance.db.entity.ItemWithCategories
import com.serranoie.wishin.domain.repositories.ItemRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCategoriesWithItemUseCase @Inject constructor(
    private val repository: ItemRepository,
) {
    operator fun invoke(): Flow<List<ItemWithCategories>> = repository.getItemsWithCategory()
}
