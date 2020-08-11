package no.nav.pensjon.innsyn.domain.desc

import no.nav.pensjon.innsyn.domain.Forstegangstjeneste
import no.nav.pensjon.innsyn.entity.EntityDescriptor

object ForstegangstjenesteDescriptor : EntityDescriptor<Forstegangstjeneste>("Førstegangstjeneste",
        arrayOf(
                "Tjenestestart",
                "Dimittert",
                "Rapporttype",
                "Status",
                "Kilde"
        )
)