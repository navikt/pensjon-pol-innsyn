package no.nav.pensjon.innsyn.popp.domain.container

import no.nav.pensjon.innsyn.popp.domain.Dagpenger
import no.nav.pensjon.innsyn.popp.repository.DagpengerRepository
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

@Component
class DagpengerContainer(repository: DagpengerRepository) : PoppContainer<Dagpenger>("Dagpenger",
        arrayOf(
                "Ferietillegg",
                "Barnetillegg",
                "Dagpenger",
                "Uavkortet grunnlag",
                "År dagpenger utbetalt",
                "Kilde",
                "Status",
                "Type",
                "Rapporttype"
        ),
        repository
)