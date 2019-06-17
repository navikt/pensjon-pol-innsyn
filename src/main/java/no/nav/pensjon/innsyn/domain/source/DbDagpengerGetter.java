package no.nav.pensjon.innsyn.domain.source;

import no.nav.pensjon.innsyn.domain.Dagpenger;
import no.nav.pensjon.innsyn.source.SourceException;
import no.nav.pensjon.innsyn.sql.DbEntityGetter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Function;

public class DbDagpengerGetter extends DbEntityGetter<Dagpenger> {

    private static final String SQL = "SELECT d.FERIETILLEGG,\n" +
            "       d.BARNETILLEGG,\n" +
            "       d.DAGPENGER,\n" +
            "       d.UAVKORTET_DP_GRLAG,\n" +
            "       d.AR,\n" +
            "       k.DEKODE  kilde,\n" +
            "       s.DEKODE  status,\n" +
            "       dt.DEKODE dagpenger_type,\n" +
            "       rt.DEKODE rapport_type\n" +
            "  FROM popp.T_DAGPENGER d\n" +
            "  JOIN popp.T_PERSON p on p.PERSON_ID = d.PERSON_id\n" +
            "  JOIN popp.T_K_KILDE_T k on k.K_KILDE_T = d.K_KILDE_T\n" +
            "  JOIN popp.T_K_DAGPENGER_S s on s.K_DAGPENGER_S = d.K_DAGPENGER_S\n" +
            "  JOIN popp.T_K_DAGPENGER_T dt on dt.K_DAGPENGER_T = d.K_DAGPENGER_T\n" +
            "  JOIN popp.T_K_RAPPORT_T rt on rt.K_RAPPORT_T = d.K_RAPPORT_T\n" +
            " WHERE p.FNR_FK = '%s'";

    private final String sql;

    public DbDagpengerGetter(String fnr) {
        this.sql = String.format(SQL, fnr);
    }

    @Override
    public String getSql() {
        return sql;
    }

    @Override
    public Function<ResultSet, Dagpenger> getMap() {
        return DbDagpengerGetter::map;
    }

    private static Dagpenger map(ResultSet source) {
        try {
            return new Dagpenger(
                    source.getDouble("ferietillegg"),
                    source.getDouble("barnetillegg"),
                    source.getDouble("dagpenger"),
                    source.getDouble("uavkortet_dp_grlag"),
                    source.getInt("ar"),
                    source.getString("kilde"),
                    source.getString("status"),
                    source.getString("dagpenger_type"),
                    source.getString("rapport_type"));
        } catch (SQLException e) {
            throw new SourceException("Mapping 'dagpenger' from DB result set failed: " + e.getMessage(), e);
        }
    }
}
