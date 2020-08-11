package no.nav.pensjon.innsyn.domain.desc

import no.nav.pensjon.innsyn.domain.Dagpenger
import no.nav.pensjon.innsyn.entity.EntityDescriptor

object DagpengerDescriptor : EntityDescriptor<Dagpenger>("Dagpenger",
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
        )
)