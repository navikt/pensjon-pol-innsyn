package no.nav.pensjon.innsyn.domain.source;

import no.nav.pensjon.innsyn.domain.Omsorg;
import no.nav.pensjon.innsyn.source.SourceException;
import no.nav.pensjon.innsyn.sql.DbEntityGetter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Function;

public class DbOmsorgGetter extends DbEntityGetter<Omsorg> {

    private static final String SQL = "SELECT o.AR,\n" +
            "       kt.DEKODE kilde,\n" +
            "       ot.DEKODE omsorg_type,\n" +
            "       os.DEKODE status\n" +
            "  FROM popp.T_OMSORG o\n" +
            "  JOIN popp.T_PERSON p on p.PERSON_ID = o.PERSON_ID\n" +
            "  JOIN popp.T_K_OMSORG_S os on os.K_OMSORG_S = o.K_OMSORG_S\n" +
            "  JOIN popp.T_K_OMSORG_T ot on ot.K_OMSORG_T = o.K_OMSORG_T\n" +
            "  JOIN popp.T_K_KILDE_T kt on kt.K_KILDE_T = o.K_KILDE_T\n" +
            " WHERE p.FNR_FK = '%s'";

    private final String sql;

    public DbOmsorgGetter(String fnr, Connection connection) {
        super(connection);
        this.sql = String.format(SQL, fnr);
    }

    @Override
    public String getSql() {
        return sql;
    }

    @Override
    public Function<ResultSet, Omsorg> getMap() {
        return DbOmsorgGetter::map;
    }

    private static Omsorg map(ResultSet source) {
        try {
            return new Omsorg(
                    source.getInt("ar"),
                    source.getString("kilde"),
                    source.getString("status"),
                    source.getString("omsorg_type"));
        } catch (SQLException e) {
            throw new SourceException("Mapping 'omsorg' from DB result set failed: " + e.getMessage(), e);
        }
    }
}
