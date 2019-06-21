package no.nav.pensjon.innsyn.domain.source;

import no.nav.pensjon.innsyn.domain.Forstegangstjeneste;
import no.nav.pensjon.innsyn.source.SourceException;
import no.nav.pensjon.innsyn.sql.DbEntityGetter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Function;

public class DbForstegangstjenesteGetter extends DbEntityGetter<Forstegangstjeneste> {

    private static final String SQL = "SELECT TO_CHAR(o.DATO_TJENESTESTART, 'DD.MM.YY') dato_tjenestestart,\n" +
            "       TO_CHAR(o.DATO_DIMITTERING, 'DD.MM.YY')   dato_dimittering,\n" +
            "       t.DEKODE                                  rapporttype,\n" +
            "       s.DEKODE                                  status,\n" +
            "       k.DEKODE                                  kilde\n" +
            "  FROM popp.T_F_TJEN_TOT o\n" +
            "  JOIN popp.T_PERSON p ON p.PERSON_ID = o.PERSON_ID\n" +
            "  JOIN popp.T_K_RAPPORT_T t ON t.K_RAPPORT_T = o.K_RAPPORT_T\n" +
            "  JOIN popp.T_K_F_TJEN_TOT_S s ON s.K_F_TJEN_TOT_S = o.K_F_TJEN_TOT_S\n" +
            "  JOIN popp.T_K_KILDE_T k ON k.K_KILDE_T = o.K_KILDE_T\n" +
            " WHERE p.FNR_FK = '%s'";

    private final String sql;

    public DbForstegangstjenesteGetter(String fnr, Connection connection) {
        super(connection);
        this.sql = String.format(SQL, fnr);
    }

    @Override
    public String getSql() {
        return sql;
    }

    @Override
    public Function<ResultSet, Forstegangstjeneste> getMap() {
        return DbForstegangstjenesteGetter::map;
    }

    private static Forstegangstjeneste map(ResultSet source) {
        try {
            return new Forstegangstjeneste(
                    source.getString("dato_tjenestestart"),
                    source.getString("dato_dimittering"),
                    source.getString("rapporttype"),
                    source.getString("status"),
                    source.getString("kilde"));
        } catch (SQLException e) {
            throw new SourceException("Mapping 'førstegangstjeneste' from DB result set failed: " + e.getMessage(), e);
        }
    }
}
