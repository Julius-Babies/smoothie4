package es.jvbabi.smoothie4.data.model

import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.id.IntIdTable

class Ingredient(id: EntityID<Int>) : Entity<Int>(id) {
    companion object : EntityClass<Int, Ingredient>(Ingredients)

    val name by Ingredients.name
    val available by Ingredients.available
}

object Ingredients : IntIdTable("ingredients") {
    val name = varchar("name", length = 128)
    val available = bool("available")
}