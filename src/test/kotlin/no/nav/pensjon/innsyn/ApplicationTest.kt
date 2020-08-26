package no.nav.pensjon.innsyn

import no.nav.pensjon.innsyn.controller.InnsynController
import org.apache.poi.ss.usermodel.CellType
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import java.io.ByteArrayInputStream
import java.io.File
import java.io.FileInputStream

@SpringBootTest(properties = [
    "spring.datasource.schema=../../test/resources/popp-schema.sql",
    "spring.datasource.data=../../test/resources/popp-data.sql"
])
@AutoConfigureMockMvc
@EnableJpaRepositories(basePackages = ["no.nav.pensjon.innsyn.repository.popp","no.nav.pensjon.innsyn.domain.popp"])
@ActiveProfiles("POPP")
internal class ApplicationTest {
    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun `Generates POPP worksheet`() {
        mockMvc.get("/innsyn/POPP") {
            headers {
                this["pid"] = "1"
            }
        }.andExpect {
            status { isOk }
            content { contentType(InnsynController.CONTENT_TYPE_EXCEL) }
        }.andReturn().response.run {
            val testBook = XSSFWorkbook(FileInputStream(File("popp-test-worksheet.xlsx")))
            XSSFWorkbook(ByteArrayInputStream(contentAsByteArray)).apply {
                Assertions.assertEquals(testBook.numberOfSheets, numberOfSheets)
                this.forEachIndexed { si, sheet ->
                    val testSheet = testBook.getSheetAt(si)
                    Assertions.assertEquals(testSheet.physicalNumberOfRows, sheet.physicalNumberOfRows)
                    sheet.forEachIndexed { ri, row ->
                        val testRow = testSheet.getRow(ri)
                        Assertions.assertEquals(testRow.physicalNumberOfCells, row.physicalNumberOfCells)
                        row.forEachIndexed { ci, cell ->
                            when(cell.cellType){
                                CellType.NUMERIC -> Assertions.assertEquals(
                                        testRow.getCell(ci)?.numericCellValue,
                                        cell.numericCellValue
                                )
                                CellType.STRING -> Assertions.assertEquals(
                                        testRow.getCell(ci)?.stringCellValue,
                                        cell.stringCellValue
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}