package es.jvbabi.smoothie4.data.model

import es.jvbabi.smoothie4.data.serializer.ProductSerializer
import kotlinx.serialization.Serializable
import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.ReferenceOption

@Serializable(with = ProductSerializer::class)
class Product(id: EntityID<Int>) : Entity<Int>(id) {
    companion object : EntityClass<Int, Product>(Products)

    var name by Products.name
    var price by Products.price
    var ingredients by Ingredient via ProductIngredients
}

object ProductIngredients : IntIdTable("product_ingredients") {
    val product = reference("product_id", Products.id, onDelete = ReferenceOption.CASCADE)
    val ingredient = reference("ingredient_id", Ingredients.id, onDelete = ReferenceOption.CASCADE)
}

object Products : IntIdTable("products") {
    val name = varchar("name", length = 128)
    val price = integer("price")
}