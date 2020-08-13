package no.nav.pensjon.innsyn.domain.popp.container

import no.nav.pensjon.innsyn.domain.popp.Opptjening
import no.nav.pensjon.innsyn.service.map.DomainRowFiller
import no.nav.pensjon.innsyn.repository.popp.OpptjeningRepository
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
        repository,
        DomainRowFiller(Opptjening::class)::setCellValues
)