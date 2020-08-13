package no.nav.pensjon.innsyn.domain.popp.container

import no.nav.pensjon.innsyn.domain.popp.Dagpenger
import no.nav.pensjon.innsyn.service.map.DomainRowFiller
import no.nav.pensjon.innsyn.repository.popp.DagpengerRepository
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
        repository,
        DomainRowFiller(Dagpenger::class)::setCellValues
)