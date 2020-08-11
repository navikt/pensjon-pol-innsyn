package no.nav.pensjon.innsyn.domain.source

import no.nav.pensjon.innsyn.domain.Forstegangstjeneste
import no.nav.pensjon.innsyn.source.SourceException
import no.nav.pensjon.innsyn.sql.DbEntityGetter
import java.sql.Connection
import java.sql.ResultSet
import java.sql.SQLException
import java.util.function.Function

class DbForstegangstjenesteGetter(fnr: String, connection: Connection) : DbEntityGetter<Forstegangstjeneste>(connection) {
    override val sql = SQL.format(fnr)

    override fun map(source: ResultSet) = try {
        Forstegangstjeneste(
                source.getString("dato_tjenestestart"),
                source.getString("dato_dimittering"),
                source.getString("rapporttype"),
                source.getString("status"),
                source.getString("kilde"))
    } catch (e: SQLException) {
        throw SourceException("Mapping 'førstegangstjeneste' from DB result set failed: ${e.message}", e)
    }

    companion object {
        private const val SQL = """SELECT TO_CHAR(o.DATO_TJENESTESTART, 'DD.MM.YY') dato_tjenestestart,
       TO_CHAR(o.DATO_DIMITTERING, 'DD.MM.YY')   dato_dimittering,
       t.DEKODE                                  rapporttype,
       s.DEKODE                                  status,
       k.DEKODE                                  kilde
  FROM popp.T_F_TJEN_TOT o
  JOIN popp.T_PERSON p ON p.PERSON_ID = o.PERSON_ID
  JOIN popp.T_K_RAPPORT_T t ON t.K_RAPPORT_T = o.K_RAPPORT_T
  JOIN popp.T_K_F_TJEN_TOT_S s ON s.K_F_TJEN_TOT_S = o.K_F_TJEN_TOT_S
  JOIN popp.T_K_KILDE_T k ON k.K_KILDE_T = o.K_KILDE_T
 WHERE p.FNR_FK = '%s'"""
    }
}