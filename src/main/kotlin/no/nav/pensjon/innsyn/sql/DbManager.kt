package no.nav.pensjon.innsyn.sql

import no.nav.pensjon.innsyn.env.EnvironmentException

internal object DbManager {
    private class DbUrl(val dbmsId: String, val url: String)

    private const val ENVIRONMENT_VARIABLE_PREFIX = "POPP_"
    private const val ORACLE_FORMAT = "jdbc:oracle:thin:%s/%s@//%s:%s/%s"
    private const val POSTGRES_FORMAT = "jdbc:postgresql://%s:%s/postgres?user=%s&password=%s"
    private val HOSTNAME = getEnvironmentVariable(ENVIRONMENT_VARIABLE_PREFIX + "HOSTNAME")
    private val PORT = getEnvironmentVariable(ENVIRONMENT_VARIABLE_PREFIX + "PORT")
    private val USERNAME = getEnvironmentVariable(ENVIRONMENT_VARIABLE_PREFIX + "USERNAME")
    private val PASSWORD = getEnvironmentVariable(ENVIRONMENT_VARIABLE_PREFIX + "PASSWORD")
    private val ORACLE = DbUrl("oracle", ORACLE_FORMAT.format(
            USERNAME,
            PASSWORD,
            HOSTNAME,
            PORT,
            getEnvironmentVariable(ENVIRONMENT_VARIABLE_PREFIX + "SERVICENAME")))
    private val POSTGRES = DbUrl("postgres", POSTGRES_FORMAT.format(
            HOSTNAME,
            PORT,
            USERNAME,
            PASSWORD))
    private val URLS = listOf(ORACLE, POSTGRES)

    private fun getEnvironmentVariable(name: String) = try {
        System.getenv(name)
    } catch (_: NullPointerException) {
        throw EnvironmentException("Missing environment variable", name)
    }

    private fun getUrl(dbmsId: String) = URLS.firstOrNull { it.dbmsId.equals(dbmsId, true) }
            ?.url
            ?: throw IllegalArgumentException(dbmsId)
}