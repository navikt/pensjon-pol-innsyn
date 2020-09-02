package no.nav.pensjon.innsyn.popp.domain.container

import no.nav.pensjon.innsyn.popp.domain.Omsorg
import no.nav.pensjon.innsyn.popp.repository.OmsorgRepository
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

@Component
class OmsorgContainer(repository: OmsorgRepository) : PoppContainer<Omsorg>("Omsorg",
        arrayOf(
                "År",
                "Kilde",
                "Type",
                "Status"
        ),
        repository
)