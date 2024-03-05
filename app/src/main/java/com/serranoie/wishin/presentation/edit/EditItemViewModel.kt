package com.serranoie.wishin.presentation.edit

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.serranoie.wishin.data.persistance.db.entity.Item
import com.serranoie.wishin.domain.usecases.item.DeleteItemUseCase
import com.serranoie.wishin.domain.usecases.item.GetItemByIdUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.util.Date

class EditItemViewModel @AssistedInject constructor(
    private val getItemByIdUseCase: GetItemByIdUseCase,
    private val deleteItemUseCase: DeleteItemUseCase,
    @Assisted private val itemId: Long,
) : ViewModel() {

    var state by mutableStateOf(DetailState())
        private set

    val isFormNotBlank: Boolean
        get() = state.name.isNotEmpty()
    private val item: Item
        get() = state.run {
            Item(
                idItem,
                name,
                usage,
                benefits,
                disadvantages,
                reminderDate,
                reminderTime,
                isBought,
            )
        }

    private fun initialize() {
        getItem()
    }

    private fun getItem() = viewModelScope.launch {
        getItemByIdUseCase(itemId).collectLatest { item ->
            state = state.copy(
                idItem = item.idItem,
                name = item.name,
                usage = item.usage,
                benefits = item.benefits,
                disadvantages = item.disadvantages,
                reminderDate = item.reminderDate,
                reminderTime = item.reminderTime,
                isBought = item.isBought,
            )
        }
    }

    fun onNameChange(name: String) {
        state = state.copy(name = name)
    }

    fun onUsageChange(usage: String) {
        state = state.copy(usage = usage)
    }
    fun onBenefitsChange(benefits: String) {
        state = state.copy(benefits = benefits)
    }
    fun onDisadvantagesChange(disadvantages: String) {
        state = state.copy(disadvantages = disadvantages)
    }
    fun onReminderDateChange(reminderDate: Date) {
        state = state.copy(reminderDate = reminderDate)
    }
    fun onReminderTimeChange(reminderTime: Date) {
        state = state.copy(reminderTime = reminderTime)
    }
    fun onBoughtStatusChange(isBought: Boolean) {
        state = state.copy(isBought = isBought)
    }
}

data class DetailState(
    val idItem: Long = 0,
    val name: String = "",
    val usage: String = "",
    val benefits: String? = "",
    val disadvantages: String = "",
    val reminderDate: Date = Date(),
    val reminderTime: Date = Date(),
    val isBought: Boolean = false,
)

class EditItemViewModelFactory(
    private val itemId: Long,
    private val assistedFactory: ItemAssitedFactory,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return assistedFactory.create(itemId) as T
    }
}

@AssistedFactory
interface ItemAssitedFactory {
    fun create(itemId: Long): EditItemViewModel
}
