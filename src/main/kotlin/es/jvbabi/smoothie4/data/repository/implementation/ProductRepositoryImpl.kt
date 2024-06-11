package es.jvbabi.smoothie4.data.repository.implementation

import es.jvbabi.smoothie4.data.model.Product
import es.jvbabi.smoothie4.data.repository.ProductRepository

class ProductRepositoryImpl : ProductRepository {
    override suspend fun getProducts(): List<Product> {
        return Product.all().toList()
    }
}