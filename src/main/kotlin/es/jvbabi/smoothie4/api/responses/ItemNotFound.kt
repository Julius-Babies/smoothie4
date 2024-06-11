package es.jvbabi.smoothie4.api.responses

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*

suspend fun ApplicationCall.itemNotFound(itemName: String) = respond(message = ErrorResponse("$itemName not found"), status = HttpStatusCode.NotFound)