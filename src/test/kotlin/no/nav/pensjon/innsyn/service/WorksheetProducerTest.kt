package no.nav.pensjon.innsyn.service

import no.nav.pensjon.innsyn.domain.popp.PoppObjects
import no.nav.pensjon.innsyn.domain.popp.container.*
import no.nav.pensjon.innsyn.repository.popp.*
import org.apache.poi.xssf.usermodel.XSSFCell
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.context.annotation.Import
import org.springframework.context.annotation.Profile
import org.springframework.test.web.servlet.MockMvc
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

@SpringBootTest(classes = [WorksheetProducer::class, BeholdningContainer::class, DagpengerContainer::class,
    ForstegangstjenesteContainer::class, FppAfpContainer::class, InntektContainer::class, OmsorgContainer::class,
    OpptjeningContainer::class])
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Profile("!test")
internal class WorksheetProducerTest {
    @MockBean
    lateinit var beholdningRepository: BeholdningRepository
    @MockBean
    lateinit var dagpengerRepository: DagpengerRepository
    @MockBean
    lateinit var forstegangstjenesteRepository: ForstegangstjenesteRepository
    @MockBean
    lateinit var fppAfpRepository: FppAfpRepository
    @MockBean
    lateinit var inntektRepository: InntektRepository
    @MockBean
    lateinit var omsorgRepository: OmsorgRepository
    @MockBean
    lateinit var opptjeningRepository: OpptjeningRepository

    @Autowired
    private lateinit var worksheetProducer: WorksheetProducer

    @BeforeAll
    fun initMocks(){
        Mockito.`when`(beholdningRepository.findAllByPersonId(1)).thenReturn(PoppObjects.beholdning)
        Mockito.`when`(dagpengerRepository.findAllByPersonId(1)).thenReturn(PoppObjects.dagpenger)
        Mockito.`when`(forstegangstjenesteRepository.findAllByPersonId(1)).thenReturn(PoppObjects.forstegangstjeneste)
        Mockito.`when`(fppAfpRepository.findAllByPersonId(1)).thenReturn(PoppObjects.fppAfp)
        Mockito.`when`(inntektRepository.findAllByPersonId(1)).thenReturn(PoppObjects.inntekt)
        Mockito.`when`(omsorgRepository.findAllByPersonId(1)).thenReturn(PoppObjects.omsorg)
        Mockito.`when`(opptjeningRepository.findAllByPersonId(1)).thenReturn(PoppObjects.opptjening)
    }

    @Test
    fun producePOPPWorksheet() {
        val testBook = XSSFWorkbook(FileInputStream(File("test-worksheet.xlsx")))
        worksheetProducer.producePOPPWorksheet(1).apply {
            assertEquals(testBook.numberOfSheets, numberOfSheets)
            this.forEachIndexed { si, sheet ->
                val testSheet = testBook.getSheetAt(si)
                assertEquals(testSheet.physicalNumberOfRows, sheet.physicalNumberOfRows)
                sheet.forEachIndexed { ri, row ->
                    val testRow = testSheet.getRow(ri)
                    assertEquals(testRow.physicalNumberOfCells, row.physicalNumberOfCells)
                    row.forEachIndexed { ci, cell ->
                        assertEquals(testRow.getCell(ci).rawValue, (cell as XSSFCell).rawValue)
                    }
                }
            }
        }
    }
}