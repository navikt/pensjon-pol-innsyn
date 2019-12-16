package no.nav.pensjon.innsyn.sql;

class DbUrl {

    static String getUrlFromEnvironment() {
        return String.format("jdbc:oracle:thin:%s/%s@//%s:%s/%s",
                System.getenv("USERNAME"),
                System.getenv("PASSWORD"),
                "dm09-scan.adeo.no",
                1521,
                "popp");
    }
}