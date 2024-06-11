package es.jvbabi.smoothie4.api.responses.bad_request

import es.jvbabi.smoothie4.api.responses.ErrorResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*

suspend fun ApplicationCall.badParam(name: String, type: String) = respond(status = HttpStatusCode.BadRequest, ErrorResponse("Parameter $name is supposed to be $type"))

object ParamTypes {
    const val BOOLEAN = "boolean"
}