package es.jvbabi.smoothie4.api.ingredient

import es.jvbabi.smoothie4.api.ingredient.item.ingredientAvailabilityRoute
import es.jvbabi.smoothie4.data.dbQuery
import es.jvbabi.smoothie4.data.repository.ingredientRepository
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.ingredientRoutes() {
    route("/ingredient") {
        get {
            dbQuery {
                call.respond(ingredientRepository.getIngredients())
            }
        }
        ingredientAvailabilityRoute()
    }
}