package es.jvbabi.smoothie4.data.model

import es.jvbabi.smoothie4.data.serializer.IngredientSerializer
import kotlinx.serialization.Serializable
import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.id.IntIdTable

@Serializable(with = IngredientSerializer::class)
class Ingredient(id: EntityID<Int>) : Entity<Int>(id) {
    companion object : EntityClass<Int, Ingredient>(Ingredients)

    var name by Ingredients.name
    var available by Ingredients.available
}

object Ingredients : IntIdTable("ingredients") {
    val name = varchar("name", length = 128)
    val available = bool("available")
}