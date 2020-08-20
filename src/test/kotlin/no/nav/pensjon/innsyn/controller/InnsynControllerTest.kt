package no.nav.pensjon.innsyn.controller

import no.nav.pensjon.innsyn.Application
import no.nav.pensjon.innsyn.controller.InnsynController.Companion.CONTENT_TYPE_EXCEL
import no.nav.pensjon.innsyn.domain.popp.container.*
import no.nav.pensjon.innsyn.service.WorksheetProducer
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.ImportAutoConfiguration
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Import
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@WebMvcTest(InnsynController::class)
@AutoConfigureDataJpa
@Import(WorksheetProducer::class, BeholdningContainer::class, DagpengerContainer::class,
        ForstegangstjenesteContainer::class, FppAfpContainer::class, InntektContainer::class, OmsorgContainer::class,
        OpptjeningContainer::class)
internal class InnsynControllerTest{
    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var worksheetProducer: WorksheetProducer

    @Test
    fun `Returns 200 and valid worksheet`(){
        mockMvc.get("/innsyn/POPP") {
            headers {
                this["pid"] = "1"
            }
        }.andExpect {
            status { isOk }
            content { contentType(CONTENT_TYPE_EXCEL) }
        }
    }
}