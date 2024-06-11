package es.jvbabi.smoothie4.data.repository.implementation

import es.jvbabi.smoothie4.data.repository.CashpointRepository
import es.jvbabi.smoothie4.data.model.Cashpoint
import es.jvbabi.smoothie4.data.model.Cashpoints
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.selectAll

class CashpointRepositoryImpl : CashpointRepository {
    companion object {
        fun ResultRow.toCashpoint(): Cashpoint = Cashpoint(
            id = this[Cashpoints.id],
            name = this[Cashpoints.name]
        )
    }
    override suspend fun getCashpoints(): List<Cashpoint> {
        return Cashpoints.selectAll().map { it.toCashpoint() }
    }
}