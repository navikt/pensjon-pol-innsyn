package no.nav.pensjon.innsyn.poi.ss;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.Network;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.MountableFile;

/**
 * This integration test uses Testcontainers to set up a dockerised PostgreSQL database on the fly.
 */
@Testcontainers
class DataTransferrerPostgresIntegrationTest {

    private static final Network network = Network.newNetwork();
    private static final String DB_NAME = "pensjon-pol";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "docker";
    private static final String LOCALHOST_IP_ADDRESS = "127.0.0.1";
    private static final String V2_POSTGRES_INIT_DB_SCRIPT_FOLDER = "/docker-entrypoint-initdb.d/V2__Create_schema.sql";
    private static final String V3_POSTGRES_INIT_DB_SCRIPT_FOLDER = "/docker-entrypoint-initdb.d/V3__Create_tables.sql";
    private static final String V4_POSTGRES_INIT_DB_SCRIPT_FOLDER = "/docker-entrypoint-initdb.d/V4__Populate_tables.sql";
    private static final String V2_INIT_SCRIPT = "db/migration/V2__Create_schema.sql";
    private static final String V3_INIT_SCRIPT = "db/migration/V3__Create_tables.sql";
    private static final String V4_INIT_SCRIPT = "db/migration/V4__Populate_tables.sql";
    private static final int DB_PORT = 5432;

    @Container
    private static PostgreSQLContainer postgresqlContainer = setUpPostgresContainer();

    private static PostgreSQLContainer setUpPostgresContainer() {
        return new PostgreSQLContainer<>()
                .withDatabaseName(DB_NAME)
                .withUsername(DB_USERNAME)
                .withPassword(DB_PASSWORD)
                .withNetworkAliases(DB_NAME)
                .withNetwork(network)
                .withExposedPorts(DB_PORT)
                .withExtraHost("host", LOCALHOST_IP_ADDRESS)
                .withCopyFileToContainer(MountableFile.forClasspathResource(V2_INIT_SCRIPT),
                        V2_POSTGRES_INIT_DB_SCRIPT_FOLDER)
                .withCopyFileToContainer(MountableFile.forClasspathResource(V3_INIT_SCRIPT),
                        V3_POSTGRES_INIT_DB_SCRIPT_FOLDER)
                .withCopyFileToContainer(MountableFile.forClasspathResource(V4_INIT_SCRIPT),
                        V4_POSTGRES_INIT_DB_SCRIPT_FOLDER);
    }

    @BeforeAll
    static void setUp() {
        postgresqlContainer.start();
    }

    @AfterAll
    static void tearDown() {
        postgresqlContainer.stop();
    }

    /**
     * Reads from a local PostgreSQL database, creates a worksheet (an Excel file),
     * reads the value of a cell in that worksheet, and asserts that the value is correct.
     */
    @Test
    void transferEntitiesToWorkbook() throws Exception {
        new IntegrationTestUtil(postgresqlContainer).transferEntitiesToWorkbook();
    }
}
