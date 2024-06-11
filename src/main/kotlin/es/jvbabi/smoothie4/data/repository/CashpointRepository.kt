package es.jvbabi.smoothie4.data.repository

import es.jvbabi.smoothie4.data.repository.implementation.CashpointRepositoryImpl
import es.jvbabi.smoothie4.data.model.Cashpoint

interface CashpointRepository {
    suspend fun getCashpoints(): List<Cashpoint>
}

val cashpointRepository: CashpointRepository = CashpointRepositoryImpl()
