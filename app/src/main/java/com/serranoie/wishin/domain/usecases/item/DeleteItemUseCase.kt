package com.serranoie.wishin.domain.usecases.item

import com.serranoie.wishin.domain.repositories.ItemRepository
import javax.inject.Inject

class DeleteItemUseCase @Inject constructor(
    private val repository: ItemRepository,
) {
    suspend operator fun invoke(id: Long) = repository.deleteItem(id)
}
