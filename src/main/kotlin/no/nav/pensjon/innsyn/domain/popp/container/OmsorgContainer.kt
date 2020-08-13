package no.nav.pensjon.innsyn.domain.popp.container

import no.nav.pensjon.innsyn.domain.popp.Omsorg
import no.nav.pensjon.innsyn.service.map.DomainRowFiller
import no.nav.pensjon.innsyn.repository.popp.OmsorgRepository
import org.springframework.stereotype.Component

@Component
class OmsorgContainer(repository: OmsorgRepository) : PoppContainer<Omsorg>("Omsorg",
        arrayOf(
                "År",
                "Kilde",
                "Type",
                "Status"
        ),
        repository,
        DomainRowFiller(Omsorg::class)::setCellValues
)