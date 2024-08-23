package ru.nemov.ittestmain

import kotlinx.coroutines.flow.Flow
import ru.nemov.ittask.data.ProductsRepository
import ru.nemov.ittask.data.model.Product

class GetAllProductsUseCase(
    private val repository: ProductsRepository
) {

    operator fun invoke(): Flow<List<Product>> {
        return repository.getAllProducts()
    }
}