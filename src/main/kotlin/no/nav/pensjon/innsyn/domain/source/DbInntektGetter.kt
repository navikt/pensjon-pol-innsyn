package no.nav.pensjon.innsyn.domain.source

import no.nav.pensjon.innsyn.domain.Inntekt
import no.nav.pensjon.innsyn.source.SourceException
import no.nav.pensjon.innsyn.sql.DbEntityGetter
import java.sql.Connection
import java.sql.ResultSet
import java.sql.SQLException

class DbInntektGetter(fnr: String, connection: Connection) : DbEntityGetter<Inntekt>(connection) {
    override val sql = SQL.format(fnr)

    override fun map(source: ResultSet) = try {
        Inntekt(
                source.getString("inntekt_type"),
                source.getString("status"),
                source.getInt("inntekt_ar"),
                source.getDouble("inntekt_belop"),
                source.getString("rapportdato"),
                source.getString("kilde"))
    } catch (e: SQLException) {
        throw SourceException("Mapping 'inntekt' from DB result set failed: ${e.message}", e)
    }

    companion object {
        private const val SQL = """  SELECT t.DEKODE                           inntekt_type,
         s.DEKODE                           status,
         i.INNTEKT_AR                       inntekt_ar,
         i.BELOP                            inntekt_belop,
         TO_CHAR(i.PI_RAPPDATO, 'DD.MM.YY') rapportdato,
         k.DEKODE                           kilde
    FROM popp.T_INNTEKT i
    JOIN popp.T_PERSON p on p.PERSON_ID = i.PERSON_ID
    JOIN popp.T_K_INNTEKT_T t on t.K_INNTEKT_T = i.K_INNTEKT_T
    JOIN popp.T_K_INNTEKT_STATUS s on s.K_INNTEKT_STATUS = i.K_INNTEKT_STATUS
    JOIN popp.T_K_KILDE_T k on k.K_KILDE_T = i.K_KILDE_T
   WHERE p.FNR_FK = '%s'
ORDER BY i.INNTEKT_AR, i.K_INNTEKT_STATUS"""
    }
}