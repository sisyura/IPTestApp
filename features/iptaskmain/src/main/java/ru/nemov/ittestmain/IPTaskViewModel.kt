package ru.nemov.ittestmain

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import ru.nemov.ittask.data.ProductsRepository

internal class IPTaskViewModel(
    private val getAllProductsUseCase: GetAllProductsUseCase
) : ViewModel() {

    val products: Flow<List<Product>> = getAllProductsUseCase.invoke()

}