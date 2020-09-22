package no.nav.pensjon.innsyn.popp.domain.container

import no.nav.pensjon.innsyn.popp.domain.Forstegangstjeneste
import no.nav.pensjon.innsyn.popp.repository.ForstegangstjenesteRepository
import org.springframework.context.annotation.Profile
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
        repository
)