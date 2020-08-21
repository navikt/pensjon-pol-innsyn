package no.nav.pensjon.innsyn.controller

import no.nav.pensjon.innsyn.controller.InnsynController.Companion.CONTENT_TYPE_EXCEL
import no.nav.pensjon.innsyn.domain.popp.PoppObjects.beholdning
import no.nav.pensjon.innsyn.domain.popp.PoppObjects.dagpenger
import no.nav.pensjon.innsyn.domain.popp.PoppObjects.forstegangstjeneste
import no.nav.pensjon.innsyn.domain.popp.PoppObjects.fppAfp
import no.nav.pensjon.innsyn.domain.popp.PoppObjects.inntekt
import no.nav.pensjon.innsyn.domain.popp.PoppObjects.omsorg
import no.nav.pensjon.innsyn.domain.popp.PoppObjects.opptjening
import no.nav.pensjon.innsyn.domain.popp.container.*
import no.nav.pensjon.innsyn.repository.popp.*
import no.nav.pensjon.innsyn.service.WorksheetProducer
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.context.annotation.Import
import org.springframework.context.annotation.Profile
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import java.io.FileOutputStream

@WebMvcTest(InnsynController::class)
@Import(WorksheetProducer::class, BeholdningContainer::class, DagpengerContainer::class,
        ForstegangstjenesteContainer::class, FppAfpContainer::class, InntektContainer::class, OmsorgContainer::class,
        OpptjeningContainer::class)
@TestInstance(PER_CLASS)
@Profile("!test")
internal class InnsynControllerTest{
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
    private lateinit var mockMvc: MockMvc

    @BeforeAll
    fun initMocks(){
        `when`(beholdningRepository.findAllByPersonId(1)).thenReturn(beholdning)
        `when`(dagpengerRepository.findAllByPersonId(1)).thenReturn(dagpenger)
        `when`(forstegangstjenesteRepository.findAllByPersonId(1)).thenReturn(forstegangstjeneste)
        `when`(fppAfpRepository.findAllByPersonId(1)).thenReturn(fppAfp)
        `when`(inntektRepository.findAllByPersonId(1)).thenReturn(inntekt)
        `when`(omsorgRepository.findAllByPersonId(1)).thenReturn(omsorg)
        `when`(opptjeningRepository.findAllByPersonId(1)).thenReturn(opptjening)
    }

    @Test
    fun `Returns 200 and valid worksheet`(){
        mockMvc.get("/innsyn/POPP") {
            accept = MediaType.ALL
            headers {
                this["pid"] = "1"
            }
        }.andExpect {
            status { isOk }
            content { contentType(CONTENT_TYPE_EXCEL) }
        }.andDo {
            print(FileOutputStream("test.xlsx"))
        }
    }
}