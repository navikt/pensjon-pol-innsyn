package no.nav.pensjon.innsyn.poi.ss;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.ClassRule;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.OracleContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

/**
 * To run this test, remove @Disabled and comment-in @BeforeAll and @AfterAll.
 */
@Testcontainers
class DataTransferrerOracleIntegrationTest {

    @ClassRule
    static OracleContainer oracleContainer;

    //@BeforeAll
    static void setUp() {
        oracleContainer = new OracleContainer("oracleinanutshell/oracle-xe-11g")
                .withUsername("system")
                .withPassword("oracle")
                .withExposedPorts(1521)
                .withInitScript("db/migration/oracle/init_popp.sql");

        oracleContainer.start();
    }

    //@AfterAll
    static void tearDown() {
        oracleContainer.stop();
    }

    @Test
    @Disabled
    void isDatabaseUp() throws SQLException {
        assertEquals(123, getSimpleValue());
    }

    /**
     * Reads from a local Oracle database, creates a worksheet (an Excel file),
     * reads the value of a cell in that worksheet, and asserts that the value is correct.
     */
    @Test
    @Disabled
    void transferEntitiesToWorkbook() throws Exception {
        new IntegrationTestUtil(oracleContainer).transferEntitiesToWorkbook();
    }

    private static int getSimpleValue() throws SQLException {
        try (HikariDataSource dataSource = new IntegrationTestUtil(oracleContainer).createDatasource();
             Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT 123 FROM dual");
             ResultSet resultSet = statement.executeQuery()) {
            resultSet.next();
            return resultSet.getInt(1);
        }
    }
}
