package ru.nemov.ittestmain

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.nemov.ittask.data.ProductsRepository

class GetAllProductsUseCase(
    private val repository: ProductsRepository
) {

    operator fun invoke(): Flow<List<Product>> {
        return repository.getAllProducts()
            .map { product ->
                product.map { it.toUiProduct() }
            }
    }
}

private fun ru.nemov.ittask.data.model.Product.toUiProduct(): Product {
    TODO("Mot implemented")
}