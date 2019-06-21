package no.nav.pensjon.innsyn.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    public static Connection get() throws SQLException {
        return DriverManager.getConnection(DbUrl.getUrlFromEnvironment());
    }
}
