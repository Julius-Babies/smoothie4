package es.jvbabi.smoothie4.data.model

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Table

@Serializable
data class Cashpoint(
    val id: Int,
    val name: String
)

object Cashpoints : Table("cashpoints") {
    val id = integer("id").autoIncrement()
    val name = varchar("name", length = 64)

    override val primaryKey = PrimaryKey(id)
}