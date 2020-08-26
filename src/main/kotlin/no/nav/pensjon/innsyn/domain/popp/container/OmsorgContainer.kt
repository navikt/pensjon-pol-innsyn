package no.nav.pensjon.innsyn.domain.popp.container

import no.nav.pensjon.innsyn.domain.popp.Omsorg
import no.nav.pensjon.innsyn.repository.popp.OmsorgRepository
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

@Component
@Profile("POPP")
class OmsorgContainer(repository: OmsorgRepository) : PoppContainer<Omsorg>("Omsorg",
        arrayOf(
                "År",
                "Kilde",
                "Type",
                "Status"
        ),
        repository
)