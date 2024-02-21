package com.serranoie.wishin.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.serranoie.wishin.common.ScreenViewState
import com.serranoie.wishin.data.persistance.db.entity.Item
import com.serranoie.wishin.domain.usecases.item.DeleteItemUseCase
import com.serranoie.wishin.domain.usecases.item.GetAllItemsUseCase
import com.serranoie.wishin.domain.usecases.item.UpdateItemUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllItemsUseCase: GetAllItemsUseCase,
    private val updateItemUseCase: UpdateItemUseCase,
    private val deleteItemUseCase: DeleteItemUseCase,
) : ViewModel() {
    private val _state: MutableStateFlow<HomeState> = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState> = _state.asStateFlow()

    private fun getAllItems() {
        getAllItemsUseCase()
            .onEach {
                _state.value = HomeState(items = ScreenViewState.Success(it))
            }
            .catch {
                _state.value = HomeState(items = ScreenViewState.Error(it.message))
            }
            .launchIn(viewModelScope)
    }

    private fun deleteItem(itemId: Long) = viewModelScope.launch {
        deleteItemUseCase(itemId)
    }
}

data class HomeState(
    val items: ScreenViewState<List<Item>> = ScreenViewState.Loading,
)
