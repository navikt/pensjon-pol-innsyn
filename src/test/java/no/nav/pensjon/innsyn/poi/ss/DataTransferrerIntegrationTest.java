package no.nav.pensjon.innsyn.poi.ss;

import no.nav.pensjon.innsyn.domain.desc.BeholdningDescriptor;
import no.nav.pensjon.innsyn.domain.map.BeholdningRowFiller;
import no.nav.pensjon.innsyn.domain.source.DbBeholdningGetter;
import no.nav.pensjon.innsyn.entity.EntitySupport;
import no.nav.pensjon.innsyn.poi.xssf.ExcelWorkbookCreator;
import no.nav.pensjon.innsyn.sink.OutputStreamCreator;

import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.HikariConfig;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.Network;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.*;
import org.testcontainers.utility.MountableFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static no.nav.pensjon.innsyn.poi.ss.DataTransferrerTest.FILE_NAME;
import static no.nav.pensjon.innsyn.poi.ss.DataTransferrerTest.getCellValue;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Reads from a local PostgreSQL database, creates a worksheet (an Excel file),
 * reads the value of a cell in that worksheet, and asserts that the value is correct.
 * Prerequisite: PostgreSQL running on localhost; install e.g. via Docker thus:
 * $ docker pull postgres
 * $ mkdir -p $HOME/Docker/Volumes/Postgres
 * $ docker run --rm  --name pg-docker -e POSTGRES_PASSWORD=docker -d -p 5432:5432 -v $HOME/Docker/Volumes/Postgres:/var/lib/postgresql/data postgres
 */
@Testcontainers
class DataTransferrerIntegrationTest {

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

    /**
     * Must match fnr used in V4__Populate_tables.sql.
     */
    private static final String FNR = "01029312345";

    @BeforeAll
    static void setUpDatabase() {
        postgresqlContainer.start();
    }

    @Test
    void transferEntitiesToWorkbook() throws Exception {
        integrate((in, out) -> {
            List<EntitySupport<?>> entitySupports = List.of(new EntitySupport<>(
                    new DbBeholdningGetter(FNR, in),
                    new BeholdningDescriptor(),
                    BeholdningRowFiller::setCellValues));

            DataTransferrer.transferEntitiesToWorkbook(entitySupports, new ExcelWorkbookCreator(), out);
        });

        var file = new File(FILE_NAME);
        assertTrue(file.exists());
        assertEquals("Beholdningstype 1", getCellValue(3));
        assertTrue(file.delete());
        assertFalse(file.exists());
    }

    @FunctionalInterface
    interface DbToStreamTransferrer {
        void transfer(Connection in, OutputStreamCreator out) throws IOException;
    }

    private static void integrate(DbToStreamTransferrer transferrer) throws IOException, SQLException {
        var streamCreator = mock(OutputStreamCreator.class);

        try (var fileOutputStream = new FileOutputStream(FILE_NAME)) {
            when(streamCreator.create()).thenReturn(fileOutputStream);

            var dataSource = createPgsqlDatasource(postgresqlContainer);
            try (var connection = dataSource.getConnection()) {
                transferrer.transfer(connection, streamCreator);
            }
        }
    }

    private static HikariDataSource createPgsqlDatasource(PostgreSQLContainer postgreSQLContainer) {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setMaxLifetime(1000);
        hikariConfig.setConnectionTimeout(250);
        hikariConfig.setJdbcUrl(postgreSQLContainer.getJdbcUrl());
        hikariConfig.setUsername(postgreSQLContainer.getUsername());
        hikariConfig.setPassword(postgreSQLContainer.getPassword());
        return new HikariDataSource(hikariConfig);
    }
}
