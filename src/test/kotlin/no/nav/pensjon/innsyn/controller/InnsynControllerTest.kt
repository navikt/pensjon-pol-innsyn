package no.nav.pensjon.innsyn.controller

import no.nav.pensjon.innsyn.controller.InnsynController.Companion.CONTENT_TYPE_EXCEL
import no.nav.pensjon.innsyn.service.WorksheetProducer
import org.apache.poi.xssf.usermodel.XSSFCell
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import java.io.ByteArrayInputStream
import java.io.File
import java.io.FileInputStream

@WebMvcTest(InnsynController::class)
internal class InnsynControllerTest {
    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var worksheetProducer: WorksheetProducer

    @Test
    fun `Returns 200 and valid worksheet`() {
        `when`(worksheetProducer.producePOPPWorksheet(1)).thenReturn(XSSFWorkbook(FileInputStream(File("test-worksheet.xlsx"))))
        mockMvc.get("/innsyn/POPP") {
            headers {
                this["pid"] = "1"
            }
        }.andExpect {
            status { isOk }
            content { contentType(CONTENT_TYPE_EXCEL) }
        }.andReturn().response.run {
            val testBook = XSSFWorkbook(FileInputStream(File("test-worksheet.xlsx")))
            XSSFWorkbook(ByteArrayInputStream(contentAsByteArray)).apply {
                Assertions.assertEquals(testBook.numberOfSheets, numberOfSheets)
                this.forEachIndexed { si, sheet ->
                    val testSheet = testBook.getSheetAt(si)
                    Assertions.assertEquals(testSheet.physicalNumberOfRows, sheet.physicalNumberOfRows)
                    sheet.forEachIndexed { ri, row ->
                        val testRow = testSheet.getRow(ri)
                        Assertions.assertEquals(testRow.physicalNumberOfCells, row.physicalNumberOfCells)
                        row.forEachIndexed { ci, cell ->
                            Assertions.assertEquals(testRow.getCell(ci).rawValue, (cell as XSSFCell).rawValue)
                        }
                    }
                }
            }
        }
    }
}