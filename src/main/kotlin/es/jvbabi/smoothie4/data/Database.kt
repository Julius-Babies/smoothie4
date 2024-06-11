package es.jvbabi.smoothie4.data

import es.jvbabi.smoothie4.data.model.Cashpoints
import es.jvbabi.smoothie4.data.model.Ingredients
import es.jvbabi.smoothie4.data.model.ProductIngredients
import es.jvbabi.smoothie4.data.model.Products
import io.ktor.server.application.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

fun Application.configureDatabase() {
    val db = Database.connect(
        "jdbc:postgresql://10.6.0.3:5432/smoothie4",
        user = "smoothie4",
        password = "ZTRgCXn4mkx9P6KuBvcg7kJMCq8JYQjqo93c885TjmD2FhEq8228sv5S26H3pn43"
    )

    transaction(db) {
        SchemaUtils.create(Cashpoints)
        SchemaUtils.create(Ingredients, Products, ProductIngredients)
    }
}