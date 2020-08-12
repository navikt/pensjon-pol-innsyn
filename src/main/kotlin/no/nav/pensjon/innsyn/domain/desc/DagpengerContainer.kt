package no.nav.pensjon.innsyn.domain.desc

import no.nav.pensjon.innsyn.domain.Dagpenger
import no.nav.pensjon.innsyn.service.map.DomainRowFiller
import no.nav.pensjon.innsyn.domain.repository.DagpengerRepository
import no.nav.pensjon.innsyn.entity.PoppContainer
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