package ru.nemov.ittestmain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject
import javax.inject.Provider

@HiltViewModel
internal class IPTaskViewModel @Inject constructor (
    getAllProductsUseCase: Provider<GetAllProductsUseCase>
) : ViewModel() {

    val products: StateFlow<List<ProductUI>> = getAllProductsUseCase.get().invoke()
        .stateIn(viewModelScope, SharingStarted.Lazily, listOf())

}