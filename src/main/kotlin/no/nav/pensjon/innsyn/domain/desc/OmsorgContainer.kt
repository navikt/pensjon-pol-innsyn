package no.nav.pensjon.innsyn.domain.desc

import no.nav.pensjon.innsyn.domain.Omsorg
import no.nav.pensjon.innsyn.service.map.DomainRowFiller
import no.nav.pensjon.innsyn.domain.repository.OmsorgRepository
import no.nav.pensjon.innsyn.entity.PoppContainer
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