package no.nav.pensjon.innsyn.domain.source;

import no.nav.pensjon.innsyn.domain.Inntekt;
import no.nav.pensjon.innsyn.source.SourceException;
import no.nav.pensjon.innsyn.sql.DbEntityGetter;

import java.sql.*;
import java.util.function.Function;

public class DbInntektGetter extends DbEntityGetter<Inntekt> {

    private static final String SQL = "  SELECT t.DEKODE                           inntekt_type,\n" +
            "         s.DEKODE                           status,\n" +
            "         i.INNTEKT_AR                       inntekt_ar,\n" +
            "         i.BELOP                            inntekt_belop,\n" +
            "         TO_CHAR(i.PI_RAPPDATO, 'DD.MM.YY') rapportdato,\n" +
            "         k.DEKODE                           kilde\n" +
            "    FROM popp.T_INNTEKT i\n" +
            "    JOIN popp.T_PERSON p on p.PERSON_ID = i.PERSON_ID\n" +
            "    JOIN popp.T_K_INNTEKT_T t on t.K_INNTEKT_T = i.K_INNTEKT_T\n" +
            "    JOIN popp.T_K_INNTEKT_STATUS s on s.K_INNTEKT_STATUS = i.K_INNTEKT_STATUS\n" +
            "    JOIN popp.T_K_KILDE_T k on k.K_KILDE_T = i.K_KILDE_T\n" +
            "   WHERE p.FNR_FK = '%s'\n" +
            "ORDER BY i.INNTEKT_AR, i.K_INNTEKT_STATUS";

    private final String sql;

    public DbInntektGetter(String fnr, Connection connection) {
        super(connection);
        this.sql = String.format(SQL, fnr);
    }

    @Override
    public String getSql() {
        return sql;
    }

    @Override
    public Function<ResultSet, Inntekt> getMap() {
        return DbInntektGetter::map;
    }

    private static Inntekt map(ResultSet source) {
        try {
            return new Inntekt(
                    source.getString("inntekt_type"),
                    source.getString("status"),
                    source.getInt("inntekt_ar"),
                    source.getDouble("inntekt_belop"),
                    source.getString("rapportdato"),
                    source.getString("kilde"));
        } catch (SQLException e) {
            throw new SourceException("Mapping 'inntekt' from DB result set failed: " + e.getMessage(), e);
        }
    }
}
