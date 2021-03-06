package no.nav.pensjon.innsyn.popp.repository

import no.nav.pensjon.innsyn.popp.domain.PoppObjects
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
class PoppRepositoriesTest{
    @Autowired
    lateinit var beholdningRepository: BeholdningRepository
    @Autowired
    lateinit var dagpengerRepository: DagpengerRepository
    @Autowired
    lateinit var forstegangstjenesteRepository: ForstegangstjenesteRepository
    @Autowired
    lateinit var fppAfpRepository: FppAfpRepository
    @Autowired
    lateinit var inntektRepository: InntektRepository
    @Autowired
    lateinit var omsorgRepository: OmsorgRepository
    @Autowired
    lateinit var opptjeningRepository: OpptjeningRepository

    @Test
    fun `Get all Beholdninger by PID`(){
        assertEquals(
                PoppObjects.beholdning,
                beholdningRepository.findAllByPersonId(1)
        )
    }

    @Test
    fun `Get all Dagpenger by PID`(){
        assertEquals(
                PoppObjects.dagpenger,
                dagpengerRepository.findAllByPersonId(1)
        )
    }

    @Test
    fun `Get all Forstegangstjenester by PID`(){
        assertEquals(
                PoppObjects.forstegangstjeneste,
                forstegangstjenesteRepository.findAllByPersonId(1)
        )
    }

    @Test
    fun `Get all FPP-AFP by PID`(){
        assertEquals(
                PoppObjects.fppAfp,
                fppAfpRepository.findAllByPersonId(1)
        )
    }

    @Test
    fun `Get all Inntekter by PID`(){
        assertEquals(
                PoppObjects.inntekt,
                inntektRepository.findAllByPersonId(1)
        )
    }

    @Test
    fun `Get all Omsorg by PID`(){
        assertEquals(
                PoppObjects.omsorg,
                omsorgRepository.findAllByPersonId(1)
        )
    }

    @Test
    fun `Get all Opptjeninger by PID`(){
        assertEquals(
                PoppObjects.opptjening,
                opptjeningRepository.findAllByPersonId(1)
        )
    }
}