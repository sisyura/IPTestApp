package ru.nemov.ittestmain

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import ru.nemov.ittask.data.ProductsRepository
import javax.inject.Inject
import javax.inject.Provider

@HiltViewModel
internal class IPTaskViewModel @Inject constructor (
    getAllProductsUseCase: Provider<GetAllProductsUseCase>
) : ViewModel() {

    val products: Flow<List<Product>> = getAllProductsUseCase.get().invoke()

}