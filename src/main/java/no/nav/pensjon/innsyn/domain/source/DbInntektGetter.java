package no.nav.pensjon.innsyn.domain.source;

import no.nav.pensjon.innsyn.domain.Inntekt;
import no.nav.pensjon.innsyn.source.EntityGetter;
import no.nav.pensjon.innsyn.source.SourceException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbInntektGetter implements EntityGetter<Inntekt> {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres?user=postgres&password=docker";

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
            "   WHERE p.fnr_fk = '%s'\n" +
            "ORDER BY i.INNTEKT_AR, i.K_INNTEKT_STATUS";

    private final String sql;

    public DbInntektGetter(String fnr) {
        this.sql = String.format(SQL, fnr);
    }

    @Override
    public List<Inntekt> getEntities() {
        try (Connection connection = DriverManager.getConnection(URL);
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            return extractEntitiesFrom(resultSet);
        } catch (SQLException e) {
            throw new SourceException("Fetching 'inntekt' entities from DB failed: " + e.getMessage(), e);
        }
    }

    private static List<Inntekt> extractEntitiesFrom(ResultSet source) throws SQLException {
        List<Inntekt> entities = new ArrayList<>();

        while (source.next()) {
            entities.add(map(source));
        }

        return entities;
    }

    private static Inntekt map(ResultSet source) throws SQLException {
        return new Inntekt(
                source.getString("inntekt_type"),
                source.getString("status"),
                source.getInt("inntekt_ar"),
                source.getDouble("inntekt_belop"),
                source.getString("rapportdato"),
                source.getString("kilde"));
    }
}
