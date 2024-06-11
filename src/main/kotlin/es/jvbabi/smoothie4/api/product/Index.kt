package es.jvbabi.smoothie4.api.product

import es.jvbabi.smoothie4.data.dbQuery
import es.jvbabi.smoothie4.data.repository.productRepository
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.productRoutes() {
    route("/product") {
        get {
            dbQuery {
                call.respond(productRepository.getProducts())
            }
        }
    }
}