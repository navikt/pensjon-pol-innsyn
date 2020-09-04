package no.nav.pensjon.innsyn.popp.controller

import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import no.nav.pensjon.innsyn.common.CONTENT_TYPE_EXCEL
import no.nav.pensjon.innsyn.popp.assertEqualsTestData
import no.nav.pensjon.innsyn.popp.service.PoppSheetProducer
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import java.io.ByteArrayInputStream
import java.io.File
import java.io.FileInputStream

@WebMvcTest(PoppController::class)
internal class PoppControllerTest{
    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockkBean
    private lateinit var poppSheetProducer: PoppSheetProducer

    @Test
    fun `Returns 200 and valid worksheet`() {
        every { poppSheetProducer.produceWorksheet(1) } returns XSSFWorkbook(FileInputStream(File("popp-test-worksheet.xlsx")))
        mockMvc.get("/innsyn") {
            headers {
                this["pid"] = "1"
            }
        }.andExpect {
            status { isOk }
            content { contentType(CONTENT_TYPE_EXCEL) }
        }.andReturn().response.run {
            XSSFWorkbook(ByteArrayInputStream(contentAsByteArray))
        }.assertEqualsTestData()
    }

    @Test
    fun `Returns 404 on missing object`(){
        every { poppSheetProducer.produceWorksheet(2) } throws EmptyResultDataAccessException(1)
        mockMvc.get("/innsyn") {
            headers {
                this["pid"] = "2"
            }
        }.andExpect {
            status { isNotFound }
            content { string("") }
        }
    }

    @Test
    fun `Returns 501 on database error`(){
        every { poppSheetProducer.produceWorksheet(3) } throws DataIntegrityViolationException("Generic SQL error")
        mockMvc.get("/innsyn") {
            headers {
                this["pid"] = "3"
            }
        }.andExpect {
            status { isInternalServerError }
            content { string("Database error.") }
        }
    }
}