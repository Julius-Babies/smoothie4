package es.jvbabi.smoothie4.plugins

import es.jvbabi.smoothie4.api.cashpoint.cashpointRoutes
import es.jvbabi.smoothie4.api.ingredient.ingredientRoutes
import es.jvbabi.smoothie4.api.product.productRoutes
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    install(Routing) {
        cashpointRoutes()
        productRoutes()
        ingredientRoutes()
    }
}