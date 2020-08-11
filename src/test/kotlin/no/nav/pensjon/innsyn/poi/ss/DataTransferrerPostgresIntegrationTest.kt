package no.nav.pensjon.innsyn.poi.ss

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.testcontainers.containers.Network
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import org.testcontainers.utility.MountableFile

/**
 * This integration test uses Testcontainers to set up a dockerised PostgreSQL database on the fly.
 */
@Testcontainers
internal class DataTransferrerPostgresIntegrationTest {
    /**
     * Reads from a local PostgreSQL database, creates a worksheet (an Excel file),
     * reads the value of a cell in that worksheet, and asserts that the value is correct.
     */
    @Test
    fun transferEntitiesToWorkbook() {
//        IntegrationTestUtil(postgresqlContainer).transferEntitiesToWorkbook()
    }

    companion object {
        private val network = Network.newNetwork()
        private const val DB_NAME = "pensjon-pol"
        private const val DB_USERNAME = "postgres"
        private const val DB_PASSWORD = "docker"
        private const val LOCALHOST_IP_ADDRESS = "127.0.0.1"
        private const val V2_POSTGRES_INIT_DB_SCRIPT_FOLDER = "/docker-entrypoint-initdb.d/V2__Create_schema.sql"
        private const val V3_POSTGRES_INIT_DB_SCRIPT_FOLDER = "/docker-entrypoint-initdb.d/V3__Create_tables.sql"
        private const val V4_POSTGRES_INIT_DB_SCRIPT_FOLDER = "/docker-entrypoint-initdb.d/V4__Populate_tables.sql"
        private const val V2_INIT_SCRIPT = "db/migration/V2__Create_schema.sql"
        private const val V3_INIT_SCRIPT = "db/migration/V3__Create_tables.sql"
        private const val V4_INIT_SCRIPT = "db/migration/V4__Populate_tables.sql"
        private const val DB_PORT = 5432

//        @Container
//        private val postgresqlContainer = setUpPostgresContainer()
//        private class CircularPostgresContainer: PostgreSQLContainer<CircularPostgresContainer>()
//        private fun setUpPostgresContainer(): PostgreSQLContainer<*> {
//            return CircularPostgresContainer()
//                    .withDatabaseName(DB_NAME)
//                    .withUsername(DB_USERNAME)
//                    .withPassword(DB_PASSWORD)
//                    .withNetworkAliases(DB_NAME)
//                    .withNetwork(network)
//                    .withExposedPorts(DB_PORT)
//                    .withExtraHost("host", LOCALHOST_IP_ADDRESS)
//                    .withCopyFileToContainer(MountableFile.forClasspathResource(V2_INIT_SCRIPT),
//                            V2_POSTGRES_INIT_DB_SCRIPT_FOLDER)
//                    .withCopyFileToContainer(MountableFile.forClasspathResource(V3_INIT_SCRIPT),
//                            V3_POSTGRES_INIT_DB_SCRIPT_FOLDER)
//                    .withCopyFileToContainer(MountableFile.forClasspathResource(V4_INIT_SCRIPT),
//                            V4_POSTGRES_INIT_DB_SCRIPT_FOLDER)
//        }
//
//        @BeforeAll
//        @JvmStatic
//        fun setUp() {
//            postgresqlContainer.start()
//        }
//
//        @AfterAll
//        @JvmStatic
//        fun tearDown() {
//            postgresqlContainer.stop()
//        }
    }
}