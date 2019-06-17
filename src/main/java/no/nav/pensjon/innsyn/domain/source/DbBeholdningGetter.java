package no.nav.pensjon.innsyn.domain.source;

import no.nav.pensjon.innsyn.domain.Beholdning;
import no.nav.pensjon.innsyn.source.SourceException;
import no.nav.pensjon.innsyn.sql.DbEntityGetter;

import java.sql.*;
import java.util.function.Function;

public class DbBeholdningGetter extends DbEntityGetter<Beholdning> {

    private static final String SQL = "   SELECT TO_CHAR(b.DATO_FOM, 'DD.MM.YY')        beholdning_dato_fom,\n" +
            "          TO_CHAR(b.DATO_TOM, 'DD.MM.YY')        beholdning_dato_tom,\n" +
            "          b.BELOP                                beholdning_belop,\n" +
            "          bt.DEKODE                              beholdning_type,\n" +
            "          bs.DEKODE                              beholdning_status,\n" +
            "          b.BEH_GRLAG                            beholdning_grlag,\n" +
            "          b.BEH_GRLAG_AVKORTET                   beholdning_grlag_avkortet,\n" +
            "          b.BEH_INNSKUDD                         beholdning_innskudd,\n" +
            "          i.AR                                   inntekt_ar,\n" +
            "          i.BELOP                                inntekt_belop,\n" +
            "          f.AR                                   forstegangstjeneste_ar,\n" +
            "          d.BELOP_ORDINAR                        dagpenger_belop_ordinar,\n" +
            "          d.AR                                   dagpenger_ar,\n" +
            "          d.BELOP_FISKERE                        dagpenger_belop_fiskere,\n" +
            "          o.AR                                   omsorg_ar,\n" +
            "          o.BELOP                                omsorg_belop,\n" +
            "          o.OMS_OPPTJ_INNSKUDD                   omsorg_opptj_innskudd,\n" +
            "          u.BELOP                                ufore_belop,\n" +
            "          u.AR                                   ufore_ar,\n" +
            "          u.UFG                                  ufore_grad,\n" +
            "          u.YUG                                  ufore_yrkesskadegrad,\n" +
            "          u.ANTATT_INNTEKT_YRKE                  ufore_antatt_inntekt_yrke,\n" +
            "          u.YRKESSKADE                           ufore_yrkesskade,\n" +
            "          u.UFORETRYGD                           ufore_uforetrygd,\n" +
            "          u.UFOREAR                              ufore_uforear,\n" +
            "          u.ANTATT_INNTEKT                       ufore_antatt_inntekt,\n" +
            "          r.REGULERINGSBELOP                     regulering_belop,\n" +
            "          TO_CHAR(r.REGULERING_DATO, 'DD.MM.YY') regulering_dato\n" +
            "     FROM popp.T_BEHOLDNING b\n" +
            "     JOIN popp.T_PERSON p ON p.PERSON_ID = b.PERSON_ID\n" +
            "LEFT JOIN popp.T_INNTEKT_OPPTJ i ON i.INNTEKT_OPPTJ_ID = b.INNTEKT_OPPTJ_ID\n" +
            "LEFT JOIN popp.T_INNTEKT pgi ON pgi.INNTEKT_ID = i.INNTEKT_ID\n" +
            "LEFT JOIN popp.T_F_TJEN_OPPTJ f ON f.F_TJEN_OPPTJ_ID = b.F_TJEN_OPPTJ_ID\n" +
            "LEFT JOIN popp.T_DAGPENGER_OPPTJ d ON d.DAGPENGER_OPPTJ_ID = b.DAGPENGER_OPPTJ_ID\n" +
            "LEFT JOIN popp.T_OMSORG_OPPTJ o ON o.OMSORG_OPPTJ_ID = b.OMSORG_OPPTJ_ID\n" +
            "LEFT JOIN popp.T_UFORE_OPPTJ u ON u.UFORE_OPPTJ_ID = b.UFORE_OPPTJ_ID\n" +
            "LEFT JOIN popp.T_LONN_VEKST_REG r ON r.LONNSVEKST_REG_ID = b.LONNSVEKST_REG_ID\n" +
            "LEFT JOIN popp.T_K_BEHOLDNING_T bt ON bt.K_BEHOLDNING_T = b.K_BEHOLDNING_T\n" +
            "LEFT JOIN popp.T_K_BEHOLDNING_S bs ON bs.K_BEHOLDNING_S = b.K_BEHOLDNING_S\n" +
            "    WHERE p.FNR_FK = '%s'\n" +
            " ORDER BY p.FNR_FK, b.DATO_FOM";

    private final String sql;

    public DbBeholdningGetter(String fnr) {
        this.sql = String.format(SQL, fnr);
    }


    @Override
    public String getSql() {
        return sql;
    }

    @Override
    public Function<ResultSet, Beholdning> getMap() {
        return DbBeholdningGetter::map;
    }

    private static Beholdning map(ResultSet source) {
        try {
            return new Beholdning(
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
                    source.getString("dagpenger_belop_ordinar"),
                    source.getInt("dagpenger_ar"),
                    source.getString("dagpenger_belop_fiskere"),
                    source.getInt("omsorg_ar"),
                    source.getDouble("omsorg_belop"),
                    source.getDouble("omsorg_opptj_innskudd"),
                    source.getDouble("ufore_belop"),
                    source.getInt("ufore_ar"),
                    source.getString("ufore_grad"),
                    source.getString("ufore_yrkesskadegrad"),
                    source.getString("ufore_antatt_inntekt_yrke"),
                    source.getString("ufore_yrkesskade"),
                    source.getString("ufore_uforetrygd"),
                    source.getInt("ufore_uforear"),
                    source.getDouble("ufore_antatt_inntekt"),
                    source.getDouble("regulering_belop"),
                    source.getString("regulering_dato"));
        } catch (SQLException e) {
            throw new SourceException("Mapping 'beholdning' from DB result set failed: " + e.getMessage(), e);
        }
    }
}
