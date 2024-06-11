package es.jvbabi.smoothie4

import es.jvbabi.smoothie4.data.configureDatabase
import es.jvbabi.smoothie4.plugins.configureRouting
import es.jvbabi.smoothie4.plugins.configureSerialization
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureDatabase()
    configureSerialization()
    configureRouting()
}
