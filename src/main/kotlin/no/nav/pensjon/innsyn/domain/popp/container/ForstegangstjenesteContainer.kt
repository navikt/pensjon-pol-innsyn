package no.nav.pensjon.innsyn.domain.popp.container

import no.nav.pensjon.innsyn.domain.popp.Forstegangstjeneste
import no.nav.pensjon.innsyn.repository.popp.ForstegangstjenesteRepository
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

@Component
@Profile("POPP")
class ForstegangstjenesteContainer(repository: ForstegangstjenesteRepository) : PoppContainer<Forstegangstjeneste>("Førstegangstjeneste",
        arrayOf(
                "Tjenestestart",
                "Dimittert",
                "Rapporttype",
                "Status",
                "Kilde"
        ),
        repository
)