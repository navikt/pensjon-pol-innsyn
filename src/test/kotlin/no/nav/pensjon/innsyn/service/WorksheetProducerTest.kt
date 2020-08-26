package no.nav.pensjon.innsyn.service

import no.nav.pensjon.innsyn.domain.popp.PoppObjects
import no.nav.pensjon.innsyn.domain.popp.container.*
import no.nav.pensjon.innsyn.domain.tp.TpObjects
import no.nav.pensjon.innsyn.domain.tp.container.ForholdContainer
import no.nav.pensjon.innsyn.domain.tp.container.YtelseContainer
import no.nav.pensjon.innsyn.repository.popp.*
import no.nav.pensjon.innsyn.repository.tp.ForholdRepository
import org.apache.poi.ss.usermodel.CellType
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.ActiveProfiles
import java.io.File
import java.io.FileInputStream

@SpringBootTest(classes = [WorksheetProducer::class, BeholdningContainer::class, DagpengerContainer::class,
    ForstegangstjenesteContainer::class, FppAfpContainer::class, InntektContainer::class, OmsorgContainer::class,
    OpptjeningContainer::class, ForholdContainer::class, YtelseContainer::class])
@ActiveProfiles("TP", "POPP")
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
    @MockBean
    lateinit var forholdRepository: ForholdRepository

    @Autowired
    private lateinit var worksheetProducer: WorksheetProducer

    @Test
    fun `Produces POPP worksheet`() {
        `when`(beholdningRepository.findAllByPersonId(1)).thenReturn(PoppObjects.beholdning)
        `when`(dagpengerRepository.findAllByPersonId(1)).thenReturn(PoppObjects.dagpenger)
        `when`(forstegangstjenesteRepository.findAllByPersonId(1)).thenReturn(PoppObjects.forstegangstjeneste)
        `when`(fppAfpRepository.findAllByPersonId(1)).thenReturn(PoppObjects.fppAfp)
        `when`(inntektRepository.findAllByPersonId(1)).thenReturn(PoppObjects.inntekt)
        `when`(omsorgRepository.findAllByPersonId(1)).thenReturn(PoppObjects.omsorg)
        `when`(opptjeningRepository.findAllByPersonId(1)).thenReturn(PoppObjects.opptjening)
        val testBook = XSSFWorkbook(FileInputStream(File("popp-test-worksheet.xlsx")))
        worksheetProducer.producePOPPWorksheet(1).apply {
            assertEquals(testBook.numberOfSheets, numberOfSheets)
            this.forEachIndexed { si, sheet ->
                val testSheet = testBook.getSheetAt(si)
                assertEquals(testSheet.physicalNumberOfRows, sheet.physicalNumberOfRows)
                sheet.forEachIndexed { ri, row ->
                    val testRow = testSheet.getRow(ri)
                    assertEquals(testRow.physicalNumberOfCells, row.physicalNumberOfCells)
                    row.forEachIndexed { ci, cell ->
                        when(cell.cellType){
                            CellType.NUMERIC -> assertEquals(
                                    testRow.getCell(ci)?.numericCellValue,
                                    cell.numericCellValue
                            )
                            CellType.STRING -> assertEquals(
                                    testRow.getCell(ci)?.stringCellValue,
                                    cell.stringCellValue
                            )
                        }
                    }
                }
            }
        }
    }

    @Test
    fun `Produces TP worksheet`() {
        `when`(forholdRepository.findAllByPersonId(1)).thenReturn(TpObjects.forhold)
        val testBook = XSSFWorkbook(FileInputStream(File("tp-test-worksheet.xlsx")))
        worksheetProducer.produceTPWorksheet(1).apply {
            assertEquals(testBook.numberOfSheets, numberOfSheets)
            this.forEachIndexed { si, sheet ->
                val testSheet = testBook.getSheetAt(si)
                assertEquals(testSheet.physicalNumberOfRows, sheet.physicalNumberOfRows)
                sheet.forEachIndexed { ri, row ->
                    val testRow = testSheet.getRow(ri)
                    assertEquals(testRow.physicalNumberOfCells, row.physicalNumberOfCells)
                    row.forEachIndexed { ci, cell ->
                        when(cell.cellType){
                            CellType.NUMERIC -> assertEquals(
                                    testRow.getCell(ci)?.numericCellValue,
                                    cell.numericCellValue
                            )
                            CellType.STRING -> assertEquals(
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