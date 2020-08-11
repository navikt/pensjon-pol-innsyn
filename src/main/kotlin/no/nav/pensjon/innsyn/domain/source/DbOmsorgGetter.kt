package no.nav.pensjon.innsyn.domain.source

import no.nav.pensjon.innsyn.domain.Omsorg
import no.nav.pensjon.innsyn.source.SourceException
import no.nav.pensjon.innsyn.sql.DbEntityGetter
import java.sql.Connection
import java.sql.ResultSet
import java.sql.SQLException
import java.util.function.Function

class DbOmsorgGetter(fnr: String, connection: Connection) : DbEntityGetter<Omsorg>(connection) {
    override val sql = SQL.format(fnr)

    override fun map(source: ResultSet) = try {
        Omsorg(
                source.getInt("ar"),
                source.getString("kilde"),
                source.getString("status"),
                source.getString("omsorg_type"))
    } catch (e: SQLException) {
        throw SourceException("Mapping 'omsorg' from DB result set failed: ${e.message}", e)
    }

    companion object {
        private const val SQL = """SELECT o.AR,
       kt.DEKODE kilde,
       ot.DEKODE omsorg_type,
       os.DEKODE status
  FROM popp.T_OMSORG o
  JOIN popp.T_PERSON p on p.PERSON_ID = o.PERSON_ID
  JOIN popp.T_K_OMSORG_S os on os.K_OMSORG_S = o.K_OMSORG_S
  JOIN popp.T_K_OMSORG_T ot on ot.K_OMSORG_T = o.K_OMSORG_T
  JOIN popp.T_K_KILDE_T kt on kt.K_KILDE_T = o.K_KILDE_T
 WHERE p.FNR_FK = '%s'"""
    }
}