package no.nav.pensjon.innsyn.domain.desc

import no.nav.pensjon.innsyn.domain.Opptjening
import no.nav.pensjon.innsyn.service.map.DomainRowFiller
import no.nav.pensjon.innsyn.domain.repository.OpptjeningRepository
import no.nav.pensjon.innsyn.entity.PoppContainer
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