package ru.nemov.ittask.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.nemov.iptestdatabase.IPTaskDatabase
import ru.nemov.ittask.data.model.Product

class ProductsRepository(
    private val database: IPTaskDatabase
) {

    fun getAllProducts(): Flow<List<Product>> {
        return database.productsDao
            .getAll()
            .map { products -> products.map { it.toProduct() } }
    }
}