package no.nav.pensjon.innsyn.domain.source

import no.nav.pensjon.innsyn.domain.Beholdning
import no.nav.pensjon.innsyn.source.SourceException
import no.nav.pensjon.innsyn.sql.DbEntityGetter
import java.sql.Connection
import java.sql.ResultSet
import java.sql.SQLException

class DbBeholdningGetter(fnr: String, connection: Connection) : DbEntityGetter<Beholdning>(connection) {
    override val sql = SQL.format(fnr)

    override fun map(source: ResultSet) = try {
        Beholdning(
                source.getString("beholdning_dato_fom"),
                source.getString("beholdning_dato_tom"),
                source.getDouble("beholdning_belop"),
                source.getString("beholdning_type"),
                source.getString("beholdning_status"),
                source.getDouble("beholdning_grlag"),
                source.getDouble("beholdning_grlag_avkortet"),
                source.getDouble("beholdning_innskudd"),
                source.getInt("inntekt_ar"),
                source.getDouble("inntekt_belop"),
                source.getInt("forstegangstjeneste_ar"),
                source.getDouble("dagpenger_belop_ordinar"),
                source.getInt("dagpenger_ar"),
                source.getDouble("dagpenger_belop_fiskere"),
                source.getInt("omsorg_ar"),
                source.getDouble("omsorg_belop"),
                source.getDouble("omsorg_opptj_innskudd"),
                source.getDouble("ufore_belop"),
                source.getInt("ufore_ar"),
                source.getDouble("ufore_grad"),
                source.getDouble("ufore_yrkesskadegrad"),
                source.getDouble("ufore_antatt_inntekt_yrke"),
                source.getNumericBoolean("ufore_yrkesskade"),
                source.getNumericBoolean("ufore_uforetrygd"),
                source.getNumericBoolean("ufore_uforear"),
                source.getDouble("ufore_antatt_inntekt"),
                source.getDouble("regulering_belop"),
                source.getString("regulering_dato"))
    } catch (e: SQLException) {
        throw SourceException("Mapping 'beholdning' from DB result set failed: ${e.message}", e)
    }

    companion object {
        private const val SQL = """   SELECT TO_CHAR(b.DATO_FOM, 'DD.MM.YY')        beholdning_dato_fom,
          TO_CHAR(b.DATO_TOM, 'DD.MM.YY')        beholdning_dato_tom,
          b.BELOP                                beholdning_belop,
          bt.DEKODE                              beholdning_type,
          bs.DEKODE                              beholdning_status,
          b.BEH_GRLAG                            beholdning_grlag,
          b.BEH_GRLAG_AVKORTET                   beholdning_grlag_avkortet,
          b.BEH_INNSKUDD                         beholdning_innskudd,
          i.AR                                   inntekt_ar,
          i.BELOP                                inntekt_belop,
          f.AR                                   forstegangstjeneste_ar,
          d.BELOP_ORDINAR                        dagpenger_belop_ordinar,
          d.AR                                   dagpenger_ar,
          d.BELOP_FISKERE                        dagpenger_belop_fiskere,
          o.AR                                   omsorg_ar,
          o.BELOP                                omsorg_belop,
          o.OMS_OPPTJ_INNSKUDD                   omsorg_opptj_innskudd,
          u.BELOP                                ufore_belop,
          u.AR                                   ufore_ar,
          u.UFG                                  ufore_grad,
          u.YUG                                  ufore_yrkesskadegrad,
          u.ANTATT_INNTEKT_YRKE                  ufore_antatt_inntekt_yrke,
          u.YRKESSKADE                           ufore_yrkesskade,
          u.UFORETRYGD                           ufore_uforetrygd,
          u.UFOREAR                              ufore_uforear,
          u.ANTATT_INNTEKT                       ufore_antatt_inntekt,
          r.REGULERINGSBELOP                     regulering_belop,
          TO_CHAR(r.REGULERING_DATO, 'DD.MM.YY') regulering_dato
     FROM popp.T_BEHOLDNING b
     JOIN popp.T_PERSON p ON p.PERSON_ID = b.PERSON_ID
LEFT JOIN popp.T_INNTEKT_OPPTJ i ON i.INNTEKT_OPPTJ_ID = b.INNTEKT_OPPTJ_ID
LEFT JOIN popp.T_INNTEKT pgi ON pgi.INNTEKT_ID = i.INNTEKT_ID
LEFT JOIN popp.T_F_TJEN_OPPTJ f ON f.F_TJEN_OPPTJ_ID = b.F_TJEN_OPPTJ_ID
LEFT JOIN popp.T_DAGPENGER_OPPTJ d ON d.DAGPENGER_OPPTJ_ID = b.DAGPENGER_OPPTJ_ID
LEFT JOIN popp.T_OMSORG_OPPTJ o ON o.OMSORG_OPPTJ_ID = b.OMSORG_OPPTJ_ID
LEFT JOIN popp.T_UFORE_OPPTJ u ON u.UFORE_OPPTJ_ID = b.UFORE_OPPTJ_ID
LEFT JOIN popp.T_LONN_VEKST_REG r ON r.LONNSVEKST_REG_ID = b.LONNSVEKST_REG_ID
LEFT JOIN popp.T_K_BEHOLDNING_T bt ON bt.K_BEHOLDNING_T = b.K_BEHOLDNING_T
LEFT JOIN popp.T_K_BEHOLDNING_S bs ON bs.K_BEHOLDNING_S = b.K_BEHOLDNING_S
    WHERE p.FNR_FK = '%s'
 ORDER BY p.FNR_FK, b.DATO_FOM"""

        @Throws(SQLException::class)
        private fun ResultSet.getNumericBoolean(column: String) = getString(column) == "1"
    }
}