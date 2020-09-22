package no.nav.pensjon.innsyn.popp.service

import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import no.nav.pensjon.innsyn.popp.assertEqualsTestData
import no.nav.pensjon.innsyn.popp.domain.PoppObjects.beholdning
import no.nav.pensjon.innsyn.popp.domain.PoppObjects.dagpenger
import no.nav.pensjon.innsyn.popp.domain.PoppObjects.forstegangstjeneste
import no.nav.pensjon.innsyn.popp.domain.PoppObjects.fppAfp
import no.nav.pensjon.innsyn.popp.domain.PoppObjects.inntekt
import no.nav.pensjon.innsyn.popp.domain.PoppObjects.omsorg
import no.nav.pensjon.innsyn.popp.domain.PoppObjects.opptjening
import no.nav.pensjon.innsyn.popp.domain.PoppObjects.person
import no.nav.pensjon.innsyn.popp.domain.container.*
import no.nav.pensjon.innsyn.popp.repository.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

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

    @MockkBean
    lateinit var personRepository: PersonRepository

    @Autowired
    private lateinit var poppSheetProducer: PoppSheetProducer

    @Test
    fun `Produces POPP poppSheet`() {
        every { beholdningRepository.findAllByPersonId(1) } returns beholdning
        every { dagpengerRepository.findAllByPersonId(1) } returns dagpenger
        every { forstegangstjenesteRepository.findAllByPersonId(1) } returns forstegangstjeneste
        every { fppAfpRepository.findAllByPersonId(1) } returns fppAfp
        every { inntektRepository.findAllByPersonId(1) } returns inntekt
        every { omsorgRepository.findAllByPersonId(1) } returns omsorg
        every { opptjeningRepository.findAllByPersonId(1) } returns opptjening
        every { personRepository.findByFnr(person.fnr) } returns person
        poppSheetProducer.produceWorksheet(person.fnr).assertEqualsTestData()
    }
}