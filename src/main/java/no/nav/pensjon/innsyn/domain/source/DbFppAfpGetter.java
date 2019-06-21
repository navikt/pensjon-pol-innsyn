package no.nav.pensjon.innsyn.domain.source;

import no.nav.pensjon.innsyn.domain.FppAfp;
import no.nav.pensjon.innsyn.source.SourceException;
import no.nav.pensjon.innsyn.sql.DbEntityGetter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Function;

public class DbFppAfpGetter extends DbEntityGetter<FppAfp> {

    private static final String SQL = "SELECT f.AFP_FPP,\n" +
            "       TO_CHAR(f.VIRK_FOM, 'DD.MM.YY') virk_fom,\n" +
            "       TO_CHAR(f.VIRK_TOM, 'DD.MM.YY') virk_tom,\n" +
            "       f.AFP_PENSJONSGRAD,\n" +
            "       f.AFP_TYPE,\n" +
            "       s.DEKODE status\n" +
            "  FROM popp.T_FPP_AFP f\n" +
            "  JOIN popp.T_PERSON p on p.PERSON_ID = f.PERSON_ID\n" +
            "  JOIN popp.T_K_FPP_AFP_S s on s.K_FPP_AFP_S = f.K_FPP_AFP_S\n" +
            " WHERE p.FNR_FK = '%s'";

    private final String sql;

    public DbFppAfpGetter(String fnr, Connection connection) {
        super(connection);
        this.sql = String.format(SQL, fnr);
    }

    @Override
    public String getSql() {
        return sql;
    }

    @Override
    public Function<ResultSet, FppAfp> getMap() {
        return DbFppAfpGetter::map;
    }

    private static FppAfp map(ResultSet source) {
        try {
            return new FppAfp(
                    source.getString("status"),
                    source.getDouble("afp_fpp"),
                    source.getString("virk_fom"),
                    source.getString("virk_tom"),
                    source.getDouble("afp_pensjonsgrad"),
                    source.getString("afp_type"));
        } catch (SQLException e) {
            throw new SourceException("Mapping 'FPP AFP' from DB result set failed: " + e.getMessage(), e);
        }
    }
}
