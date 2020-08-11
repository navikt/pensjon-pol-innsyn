package no.nav.pensjon.innsyn.sql

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

object DbConnection {
    @Throws(SQLException::class)
    fun get(): Connection = DriverManager.getConnection(DbManager.urlFromEnvironment)
}