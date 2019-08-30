package no.nav.pensjon.innsyn.poi.ss;

import no.nav.pensjon.innsyn.domain.desc.BeholdningDescriptor;
import no.nav.pensjon.innsyn.domain.map.BeholdningRowFiller;
import no.nav.pensjon.innsyn.domain.source.DbBeholdningGetter;
import no.nav.pensjon.innsyn.entity.EntitySupport;
import no.nav.pensjon.innsyn.poi.xssf.ExcelWorkbookCreator;
import no.nav.pensjon.innsyn.sink.OutputStreamCreator;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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
class DataTransferrerIntegrationTest {

    private static final String DB_URL_BASE = "jdbc:postgresql://localhost:5432/postgres";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "docker";

    /**
     * Must match fnr used in V4__Populate_tables.sql.
     */
    private static final String FNR = "01029312345";

    @BeforeAll
    static void setUpDatabase() {
        var flyway = Flyway.configure().dataSource(DB_URL_BASE, DB_USERNAME, DB_PASSWORD).load();
        flyway.baseline();
        flyway.migrate();
        flyway.validate();
    }

    //@Test
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
        var dbUrl = String.format("%s?user=%s&password=%s", DB_URL_BASE, DB_USERNAME, DB_PASSWORD);

        try (var fileOutputStream = new FileOutputStream(FILE_NAME)) {
            when(streamCreator.create()).thenReturn(fileOutputStream);

            try (var connection = DriverManager.getConnection(dbUrl)) {
                transferrer.transfer(connection, streamCreator);
            }
        }
    }
}
