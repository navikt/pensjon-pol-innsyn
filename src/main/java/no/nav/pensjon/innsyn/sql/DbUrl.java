package no.nav.pensjon.innsyn.sql;

import no.nav.pensjon.innsyn.env.EnvironmentException;

import java.util.List;

class DbUrl {

    private static final String ENVIRONMENT_VARIABLE_PREFIX = "POPP_";
    private static final String HOSTNAME = getEnvironmentVariable(ENVIRONMENT_VARIABLE_PREFIX + "HOSTNAME");
    private static final String PORT = getEnvironmentVariable(ENVIRONMENT_VARIABLE_PREFIX + "PORT");
    private static final String USERNAME = getEnvironmentVariable(ENVIRONMENT_VARIABLE_PREFIX + "USERNAME");
    private static final String PASSWORD = getEnvironmentVariable(ENVIRONMENT_VARIABLE_PREFIX + "PASSWORD");

    private static final DbUrl ORACLE = new DbUrl("oracle",
            String.format("jdbc:oracle:thin:%s/%s@//%s:%s/%s",
                    USERNAME,
                    PASSWORD,
                    HOSTNAME,
                    PORT,
                    getEnvironmentVariable(ENVIRONMENT_VARIABLE_PREFIX + "SERVICENAME")));

    private static final DbUrl POSTGRES = new DbUrl("postgres",
            String.format("jdbc:postgresql://%s:%s/postgres?user=%s&password=%s",
                    HOSTNAME,
                    PORT,
                    USERNAME,
                    PASSWORD));

    private static final List<DbUrl> URLS = List.of(ORACLE, POSTGRES);

    private final String dbmsId;
    private final String url;

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

    private DbUrl(String dbmsId, String url) {
        this.dbmsId = dbmsId;
        this.url = url;
    }

    private static String getUrl(String dbmsId) {
        return URLS
                .stream()
                .filter(x -> x.dbmsId.equals(dbmsId.toLowerCase()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(dbmsId))
                .url;
    }
}
