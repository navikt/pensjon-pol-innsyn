package no.nav.pensjon.innsyn.sql;

import no.nav.pensjon.innsyn.env.EnvironmentException;

import java.util.List;

class DbUrl {

    private static final String ENVIRONMENT_VARIABLE_PREFIX = "POPP_";
    private static final String HOSTNAME = System.getenv(ENVIRONMENT_VARIABLE_PREFIX + "HOSTNAME");
    private static final String PORT = System.getenv(ENVIRONMENT_VARIABLE_PREFIX + "PORT");
    private static final String USERNAME = System.getenv(ENVIRONMENT_VARIABLE_PREFIX + "USERNAME");
    private static final String PASSWORD = System.getenv(ENVIRONMENT_VARIABLE_PREFIX + "PASSWORD");
    private final String dbmsId;
    private final String urlFormat;

    private static final DbUrl ORACLE = new DbUrl("oracle",
            String.format("jdbc:oracle:thin:%s/%s@//%s:%s/%s",
                    USERNAME,
                    PASSWORD,
                    HOSTNAME,
                    PORT,
                    System.getenv(ENVIRONMENT_VARIABLE_PREFIX + "SERVICENAME")));

    private static final DbUrl POSTGRES = new DbUrl("postgres",
            String.format("jdbc:postgresql://%s:%s/postgres?user=%s&password=%s",
                    HOSTNAME,
                    PORT,
                    USERNAME,
                    PASSWORD));

    private static final List<DbUrl> URLS = List.of(ORACLE, POSTGRES);

    static String getUrlFromEnvironment() {
        return getUrl(getEnvironmentVariable(ENVIRONMENT_VARIABLE_PREFIX + "DBMS"));
    }

    private static String getEnvironmentVariable(String name) {
        String value = System.getenv(name);
        return value == null ? handleMissingEnvironmentVariable(name) : value;
    }

    private static String handleMissingEnvironmentVariable(String name) {
        throw new EnvironmentException("Missing environment variable", name);
    }

    private DbUrl(String dbmsId, String urlFormat) {
        this.dbmsId = dbmsId;
        this.urlFormat = urlFormat;
    }

    private static String getUrl(String dbmsId) {
        return URLS
                .stream()
                .filter(x -> x.dbmsId.equals(dbmsId.toLowerCase()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(dbmsId))
                .urlFormat;
    }
}
