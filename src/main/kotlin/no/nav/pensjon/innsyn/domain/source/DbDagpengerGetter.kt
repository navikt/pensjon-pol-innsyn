package no.nav.pensjon.innsyn.domain.source

import no.nav.pensjon.innsyn.domain.Dagpenger
import no.nav.pensjon.innsyn.source.SourceException
import no.nav.pensjon.innsyn.sql.DbEntityGetter
import java.sql.Connection
import java.sql.ResultSet
import java.sql.SQLException

class DbDagpengerGetter(fnr: String, connection: Connection) : DbEntityGetter<Dagpenger>(connection) {
    override val sql = SQL.format(fnr)

    override fun map(source: ResultSet) = try {
        Dagpenger(
                source.getDouble("ferietillegg"),
                source.getDouble("barnetillegg"),
                source.getDouble("dagpenger"),
                source.getDouble("uavkortet_dp_grlag"),
                source.getInt("ar"),
                source.getString("kilde"),
                source.getString("status"),
                source.getString("dagpenger_type"),
                source.getString("rapport_type"))
    } catch (e: SQLException) {
        throw SourceException("Mapping 'dagpenger' from DB result set failed: ${e.message}", e)
    }

    companion object {
        private const val SQL = """SELECT d.FERIETILLEGG,
       d.BARNETILLEGG,
       d.DAGPENGER,
       d.UAVKORTET_DP_GRLAG,
       d.AR,
       k.DEKODE  kilde,
       s.DEKODE  status,
       dt.DEKODE dagpenger_type,
       rt.DEKODE rapport_type
  FROM popp.T_DAGPENGER d
  JOIN popp.T_PERSON p on p.PERSON_ID = d.PERSON_id
  JOIN popp.T_K_KILDE_T k on k.K_KILDE_T = d.K_KILDE_T
  JOIN popp.T_K_DAGPENGER_S s on s.K_DAGPENGER_S = d.K_DAGPENGER_S
  JOIN popp.T_K_DAGPENGER_T dt on dt.K_DAGPENGER_T = d.K_DAGPENGER_T
  JOIN popp.T_K_RAPPORT_T rt on rt.K_RAPPORT_T = d.K_RAPPORT_T
 WHERE p.FNR_FK = '%s'"""
    }
}