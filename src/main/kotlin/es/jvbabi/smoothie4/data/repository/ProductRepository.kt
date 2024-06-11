package es.jvbabi.smoothie4.data.repository

import es.jvbabi.smoothie4.data.model.Product
import es.jvbabi.smoothie4.data.repository.implementation.ProductRepositoryImpl

interface ProductRepository {
    suspend fun getProducts(): List<Product>
}

val productRepository: ProductRepository = ProductRepositoryImpl()