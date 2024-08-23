package ru.nemov.iptestdatabase.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import ru.nemov.iptestdatabase.models.ProductDBO

@Dao
interface ProductDao {

    @Query("SELECT * FROM products")
    fun getAll(): Flow<List<ProductDBO>>

    @Query("UPDATE products SET amount = :amount WHERE id = :productId")
    suspend fun updateProductAmount(productId: Int, amount: Int)

    @Delete
    suspend fun deleteProduct(product: ProductDBO)
}