package no.nav.pensjon.innsyn.domain.desc

import no.nav.pensjon.innsyn.domain.Omsorg
import no.nav.pensjon.innsyn.entity.EntityDescriptor

object OmsorgDescriptor : EntityDescriptor<Omsorg>("Omsorg",
        arrayOf(
                "År",
                "Kilde",
                "Type",
                "Status"
        )
)