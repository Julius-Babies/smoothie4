package es.jvbabi.smoothie4.api.ingredient.item

import es.jvbabi.smoothie4.api.responses.bad_request.ParamTypes.BOOLEAN
import es.jvbabi.smoothie4.api.responses.bad_request.badParam
import es.jvbabi.smoothie4.api.responses.bad_request.paramMissing
import es.jvbabi.smoothie4.api.responses.itemNotFound
import es.jvbabi.smoothie4.data.dbQuery
import es.jvbabi.smoothie4.data.repository.ingredientRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.ingredientAvailabilityRoute() {
    route("/{id}/availability") {
        patch {
            val id = call.parameters["id"]!!
            val isAvailable = (call.request.queryParameters["is_available"] ?: return@patch call.paramMissing("is_available")).toBooleanStrictOrNull() ?: return@patch call.badParam("is_available", BOOLEAN)
            dbQuery {
                val ingredient = ingredientRepository.getIngredientById(id.toInt()) ?: return@dbQuery call.itemNotFound("ingredient")
                ingredientRepository.setAvailability(ingredient.id.value, isAvailable)
                call.respond(HttpStatusCode.OK)
            }
        }
    }
}