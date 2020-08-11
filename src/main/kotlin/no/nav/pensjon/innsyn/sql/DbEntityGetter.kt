package no.nav.pensjon.innsyn.sql

import no.nav.pensjon.innsyn.source.EntityGetter
import no.nav.pensjon.innsyn.source.SourceException
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException
import java.util.*

abstract class DbEntityGetter<T> protected constructor(private val connection: Connection) : EntityGetter<T> {
    abstract val sql: String
    abstract fun map(source: ResultSet): T
    override val entities: List<T>
        get() =
            try {
                connection.prepareStatement(sql)
                        .use(PreparedStatement::executeQuery)
                        .use(this::extractEntitiesFrom)
            } catch (e: SQLException) {
                throw SourceException("Fetching entities from DB failed: ${e.message}", e)
            }

    @Throws(SQLException::class)
    private fun extractEntitiesFrom(source: ResultSet) =
        ArrayList<T>().apply{
            while (source.next()) add(map(source))
        }

}