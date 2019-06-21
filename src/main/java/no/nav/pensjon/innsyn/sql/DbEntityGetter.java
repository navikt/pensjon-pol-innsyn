package no.nav.pensjon.innsyn.sql;

import no.nav.pensjon.innsyn.source.EntityGetter;
import no.nav.pensjon.innsyn.source.SourceException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public abstract class DbEntityGetter<T> implements EntityGetter<T> {

    private final Connection connection;

    protected DbEntityGetter(Connection connection) {
        this.connection = connection;
    }

    public abstract String getSql();

    public abstract Function<ResultSet, T> getMap();

    @Override
    public List<T> getEntities() {
        try (PreparedStatement statement = connection.prepareStatement(getSql());
             ResultSet resultSet = statement.executeQuery()) {
            return extractEntitiesFrom(resultSet);
        } catch (SQLException e) {
            throw new SourceException("Fetching entities from DB failed: " + e.getMessage(), e);
        }
    }

    private List<T> extractEntitiesFrom(ResultSet source) throws SQLException {
        List<T> entities = new ArrayList<>();

        while (source.next()) {
            entities.add(getMap().apply(source));
        }

        return entities;
    }
}
