package es.jvbabi.smoothie4.api.responses.bad_request

import es.jvbabi.smoothie4.api.responses.ErrorResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*

suspend fun ApplicationCall.paramMissing(name: String) = respond(status = HttpStatusCode.BadRequest, ErrorResponse("Parameter $name is missing"))