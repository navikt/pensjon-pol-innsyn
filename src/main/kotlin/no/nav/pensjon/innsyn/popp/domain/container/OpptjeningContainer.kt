package no.nav.pensjon.innsyn.popp.domain.container

import no.nav.pensjon.innsyn.popp.domain.Opptjening
import no.nav.pensjon.innsyn.popp.repository.OpptjeningRepository
import org.springframework.stereotype.Component

@Component
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