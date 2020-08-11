package no.nav.pensjon.innsyn.domain.source

import no.nav.pensjon.innsyn.domain.FppAfp
import no.nav.pensjon.innsyn.source.SourceException
import no.nav.pensjon.innsyn.sql.DbEntityGetter
import java.sql.Connection
import java.sql.ResultSet
import java.sql.SQLException
import java.util.function.Function

class DbFppAfpGetter(fnr: String, connection: Connection) : DbEntityGetter<FppAfp>(connection) {
    override val sql = SQL.format(fnr)

    override fun map(source: ResultSet): FppAfp {
        return try {
            FppAfp(
                    source.getString("status"),
                    source.getDouble("afp_fpp"),
                    source.getString("virk_fom"),
                    source.getString("virk_tom"),
                    source.getDouble("afp_pensjonsgrad"),
                    source.getString("afp_type"))
        } catch (e: SQLException) {
            throw SourceException("Mapping 'FPP AFP' from DB result set failed: ${e.message}", e)
        }
    }

    companion object {
        private const val SQL = """SELECT f.AFP_FPP,
       TO_CHAR(f.VIRK_FOM, 'DD.MM.YY') virk_fom,
       TO_CHAR(f.VIRK_TOM, 'DD.MM.YY') virk_tom,
       f.AFP_PENSJONSGRAD,
       f.AFP_TYPE,
       s.DEKODE status
  FROM popp.T_FPP_AFP f
  JOIN popp.T_PERSON p on p.PERSON_ID = f.PERSON_ID
  JOIN popp.T_K_FPP_AFP_S s on s.K_FPP_AFP_S = f.K_FPP_AFP_S
 WHERE p.FNR_FK = '%s'"""
    }
}