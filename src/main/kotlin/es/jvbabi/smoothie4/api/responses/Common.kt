package es.jvbabi.smoothie4.api.responses

import kotlinx.serialization.Serializable

@Serializable
data class ErrorResponse(val error: String)