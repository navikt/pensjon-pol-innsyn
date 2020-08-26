package no.nav.pensjon.innsyn.repository

import no.nav.pensjon.innsyn.domain.tp.TpObjects
import no.nav.pensjon.innsyn.repository.tp.ForholdRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import kotlin.test.assertEquals

@DataJpaTest(properties = [
    "spring.datasource.schema=tp-schema.sql",
    "spring.datasource.data=tp-data.sql"
])
class TpRepositoriesTest{
    @Autowired
    lateinit var forholdRepository: ForholdRepository

    @Test
    fun `Get all Beholdninger by PID`(){
        assertEquals(
                TpObjects.forhold,
                forholdRepository.findAllByPersonId(1)
        )
    }
}