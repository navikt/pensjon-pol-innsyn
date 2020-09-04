package no.nav.pensjon.innsyn.popp.service

import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import no.nav.pensjon.innsyn.popp.assertEqualsTestData
import no.nav.pensjon.innsyn.popp.domain.PoppObjects
import no.nav.pensjon.innsyn.popp.domain.container.*
import no.nav.pensjon.innsyn.popp.repository.*
import org.apache.poi.ss.usermodel.CellType
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import java.io.File
import java.io.FileInputStream
import kotlin.test.assertEquals
import kotlin.test.fail

@SpringBootTest(classes = [PoppSheetProducer::class, BeholdningContainer::class, DagpengerContainer::class,
    ForstegangstjenesteContainer::class, FppAfpContainer::class, InntektContainer::class, OmsorgContainer::class,
    OpptjeningContainer::class])
@ActiveProfiles("POPP")
internal class PoppSheetProducerTest {
    @MockkBean
    lateinit var beholdningRepository: BeholdningRepository
    @MockkBean
    lateinit var dagpengerRepository: DagpengerRepository
    @MockkBean
    lateinit var forstegangstjenesteRepository: ForstegangstjenesteRepository
    @MockkBean
    lateinit var fppAfpRepository: FppAfpRepository
    @MockkBean
    lateinit var inntektRepository: InntektRepository
    @MockkBean
    lateinit var omsorgRepository: OmsorgRepository
    @MockkBean
    lateinit var opptjeningRepository: OpptjeningRepository

    @Autowired
    private lateinit var poppSheetProducer: PoppSheetProducer

    @Test
    fun `Produces POPP poppSheet`() {
        PoppObjects.apply {
            every { beholdningRepository.findAllByPersonId(1) } returns beholdning
            every { dagpengerRepository.findAllByPersonId(1) } returns dagpenger
            every { forstegangstjenesteRepository.findAllByPersonId(1) } returns forstegangstjeneste
            every { fppAfpRepository.findAllByPersonId(1) } returns fppAfp
            every { inntektRepository.findAllByPersonId(1) } returns inntekt
            every { omsorgRepository.findAllByPersonId(1) } returns omsorg
            every { opptjeningRepository.findAllByPersonId(1) } returns opptjening
        }
        poppSheetProducer.produceWorksheet(1).assertEqualsTestData()
    }
}