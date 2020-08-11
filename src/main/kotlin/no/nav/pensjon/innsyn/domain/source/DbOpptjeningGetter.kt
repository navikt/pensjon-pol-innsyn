package no.nav.pensjon.innsyn.domain.source

import no.nav.pensjon.innsyn.domain.Opptjening
import no.nav.pensjon.innsyn.source.SourceException
import no.nav.pensjon.innsyn.sql.DbEntityGetter
import java.sql.Connection
import java.sql.ResultSet
import java.sql.SQLException
import java.util.function.Function

class DbOpptjeningGetter(fnr: String, connection: Connection) : DbEntityGetter<Opptjening>(connection) {
    override val sql = SQL.format(fnr)

    override fun map(source: ResultSet) = try {
        Opptjening(
                source.getString("opptjn_type"),
                source.getString("status"),
                source.getInt("opptjn_ar"),
                source.getDouble("pgi_anvendt"),
                source.getDouble("poeng"),
                source.getDouble("max_uforegrad"))
    } catch (e: SQLException) {
        throw SourceException("Mapping 'opptjening' from DB result set failed: " + e.message, e)
    }

    companion object {
        private const val SQL = """  SELECT o.OPPTJN_AR,
         o.PGI_ANVENDT,
         o.POENG,
         o.MAX_UFOREGRAD,
         ot.DEKODE opptjn_type,
         os.DEKODE status
    FROM popp.T_OPPTJN o
    JOIN popp.T_PERSON p ON p.PERSON_ID = o.PERSON_ID_OPPTJN
    JOIN popp.T_K_OPPTJN_T ot ON ot.K_OPPTJN_T = o.K_OPPTJN_T
    JOIN popp.T_K_KILDE_T kilde ON kilde.K_KILDE_T = o.K_KILDE_T
    JOIN popp.T_K_OPPTJN_STATUS os ON os.K_OPPTJN_STATUS = o.K_OPPTJN_STATUS
   WHERE p.FNR_FK = '%s'
ORDER BY o.OPPTJN_AR, o.K_OPPTJN_STATUS"""
    }
}