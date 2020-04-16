package no.nav.pensjon.innsyn.poi.ss;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import no.nav.pensjon.innsyn.domain.desc.BeholdningDescriptor;
import no.nav.pensjon.innsyn.domain.map.BeholdningRowFiller;
import no.nav.pensjon.innsyn.domain.source.DbBeholdningGetter;
import no.nav.pensjon.innsyn.entity.EntitySupport;
import no.nav.pensjon.innsyn.poi.xssf.ExcelWorkbookCreator;
import no.nav.pensjon.innsyn.sink.OutputStreamCreator;
import org.testcontainers.containers.JdbcDatabaseContainer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static no.nav.pensjon.innsyn.poi.ss.DataTransferrerTest.FILE_NAME;
import static no.nav.pensjon.innsyn.poi.ss.DataTransferrerTest.getCellValue;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class IntegrationTestUtil {

    /**
     * Must match fnr used in V4__Populate_tables.sql and init_popp.sql.
     */
    private static final String FNR = "01029312345";

    private final JdbcDatabaseContainer<?> container;

    IntegrationTestUtil(JdbcDatabaseContainer<?> container) {
        this.container = container;
    }

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

    HikariDataSource createDatasource() {
        HikariConfig config = new HikariConfig();
        config.setMaxLifetime(1000);
        config.setConnectionTimeout(250);
        config.setJdbcUrl(container.getJdbcUrl());
        config.setUsername(container.getUsername());
        config.setPassword(container.getPassword());
        return new HikariDataSource(config);
    }

    private void integrate(DbToStreamTransferrer transferrer) throws IOException, SQLException {
        var streamCreator = mock(OutputStreamCreator.class);

        try (var fileOutputStream = new FileOutputStream(FILE_NAME)) {
            when(streamCreator.create()).thenReturn(fileOutputStream);

            try (var dataSource = createDatasource();
                 var connection = dataSource.getConnection()) {
                transferrer.transfer(connection, streamCreator);
            }
        }
    }
}
