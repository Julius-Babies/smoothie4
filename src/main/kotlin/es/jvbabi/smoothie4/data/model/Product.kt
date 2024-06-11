package es.jvbabi.smoothie4.data.model

import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.ReferenceOption

class Product(id: EntityID<Int>) : Entity<Int>(id) {
    companion object : EntityClass<Int, Product>(Products)

    val name by Products.name
    val price by Products.price
    val ingredients by Ingredient via ProductIngredients
}

object ProductIngredients : IntIdTable("product_ingredients") {
    val product = reference("product_id", Products.id, onDelete = ReferenceOption.CASCADE)
    val ingredient = reference("ingredient_id", Ingredients.id, onDelete = ReferenceOption.CASCADE)
}

object Products : IntIdTable("products") {
    val name = varchar("name", length = 128)
    val price = integer("price")
}