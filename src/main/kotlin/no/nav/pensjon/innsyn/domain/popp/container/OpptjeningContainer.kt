package no.nav.pensjon.innsyn.domain.popp.container

import no.nav.pensjon.innsyn.domain.popp.Opptjening
import no.nav.pensjon.innsyn.repository.popp.OpptjeningRepository
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

@Component
@Profile("POPP")
class OpptjeningContainer(repository: OpptjeningRepository) : PoppContainer<Opptjening>("Opptjening",
        arrayOf(
                "Type",
                "Status",
                "Opptjeningsår",
                "Pensjonsgivende inntekt",
                "Poeng",
                "Uføregrad"
        ),
        repository
)