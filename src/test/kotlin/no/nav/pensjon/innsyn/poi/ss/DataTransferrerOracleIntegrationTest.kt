package no.nav.pensjon.innsyn.poi.ss

import org.junit.Assert
import org.junit.ClassRule
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.testcontainers.containers.OracleContainer
import org.testcontainers.junit.jupiter.Testcontainers

/**
 * To run this test, remove @Disabled and comment-in @BeforeAll and @AfterAll.
 */
@Testcontainers
internal class DataTransferrerOracleIntegrationTest {
    @Disabled
    @Test
    fun `Database is up`() {
//        Assert.assertEquals(123, simpleValue.toLong())
    }

    /**
     * Reads from a local Oracle database, creates a worksheet (an Excel file),
     * reads the value of a cell in that worksheet, and asserts that the value is correct.
     */
    @Test
    @Disabled
    fun `Transfer entities to workbook`() {
//        IntegrationTestUtil(oracleContainer).transferEntitiesToWorkbook()
    }

    companion object {
//        @ClassRule
//        var oracleContainer: OracleContainer = OracleContainer("oracleinanutshell/oracle-xe-11g")
//                .withUsername("system")
//                .withPassword("oracle")
//                .withExposedPorts(1521)
//                .withInitScript("db/migration/oracle/init_popp.sql")
//
//        @BeforeAll
//        @JvmStatic
//        fun startUp() {
//            oracleContainer.start()
//        }
//
//        @AfterAll
//        @JvmStatic
//        fun tearDown() {
//            oracleContainer.stop()
//        }
//
//        private val simpleValue: Int
//            get() {
//                IntegrationTestUtil(oracleContainer).createDatasource().use { dataSource ->
//                    dataSource.connection.use { connection ->
//                        connection.prepareStatement("SELECT 123 FROM dual").use { statement ->
//                            statement.executeQuery().use { resultSet ->
//                                resultSet.next()
//                                return resultSet.getInt(1)
//                            }
//                        }
//                    }
//                }
//            }
//    }
    }
}