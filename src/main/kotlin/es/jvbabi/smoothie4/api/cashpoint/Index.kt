package es.jvbabi.smoothie4.api.cashpoint

import es.jvbabi.smoothie4.data.dbQuery
import es.jvbabi.smoothie4.data.repository.cashpointRepository
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.cashpointRoutes() {
    route("/cashpoint") {
        get {
            dbQuery {
                call.respond(cashpointRepository.getCashpoints())
            }
        }
    }
}