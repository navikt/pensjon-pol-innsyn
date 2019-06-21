package no.nav.pensjon.innsyn.domain.source;

import no.nav.pensjon.innsyn.domain.Opptjening;
import no.nav.pensjon.innsyn.source.SourceException;
import no.nav.pensjon.innsyn.sql.DbEntityGetter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Function;

public class DbOpptjeningGetter extends DbEntityGetter<Opptjening> {

    private static final String SQL = "  SELECT o.OPPTJN_AR,\n" +
            "         o.PGI_ANVENDT,\n" +
            "         o.POENG,\n" +
            "         o.MAX_UFOREGRAD,\n" +
            "         ot.DEKODE opptjn_type,\n" +
            "         os.DEKODE status\n" +
            "    FROM popp.T_OPPTJN o\n" +
            "    JOIN popp.T_PERSON p ON p.PERSON_ID = o.PERSON_ID_OPPTJN\n" +
            "    JOIN popp.T_K_OPPTJN_T ot ON ot.K_OPPTJN_T = o.K_OPPTJN_T\n" +
            "    JOIN popp.T_K_KILDE_T kilde ON kilde.K_KILDE_T = o.K_KILDE_T\n" +
            "    JOIN popp.T_K_OPPTJN_STATUS os ON os.K_OPPTJN_STATUS = o.K_OPPTJN_STATUS\n" +
            "   WHERE p.FNR_FK = '%s'\n" +
            "ORDER BY o.OPPTJN_AR, o.K_OPPTJN_STATUS";

    private final String sql;

    public DbOpptjeningGetter(String fnr, Connection connection) {
        super(connection);
        this.sql = String.format(SQL, fnr);
    }

    @Override
    public String getSql() {
        return sql;
    }

    @Override
    public Function<ResultSet, Opptjening> getMap() {
        return DbOpptjeningGetter::map;
    }

    private static Opptjening map(ResultSet source) {
        try {
            return new Opptjening(
                    source.getString("opptjn_type"),
                    source.getString("status"),
                    source.getInt("opptjn_ar"),
                    source.getDouble("pgi_anvendt"),
                    source.getDouble("poeng"),
                    source.getDouble("max_uforegrad"));
        } catch (SQLException e) {
            throw new SourceException("Mapping 'opptjening' from DB result set failed: " + e.getMessage(), e);
        }
    }
}
