package no.nav.pensjon.innsyn.domain.desc

import no.nav.pensjon.innsyn.domain.Forstegangstjeneste
import no.nav.pensjon.innsyn.service.map.DomainRowFiller
import no.nav.pensjon.innsyn.domain.repository.ForstegangstjenesteRepository
import no.nav.pensjon.innsyn.entity.PoppContainer
import org.springframework.stereotype.Component

@Component
class ForstegangstjenesteContainer(repository: ForstegangstjenesteRepository) : PoppContainer<Forstegangstjeneste>("Førstegangstjeneste",
        arrayOf(
                "Tjenestestart",
                "Dimittert",
                "Rapporttype",
                "Status",
                "Kilde"
        ),
        repository,
        DomainRowFiller(Forstegangstjeneste::class)::setCellValues
)