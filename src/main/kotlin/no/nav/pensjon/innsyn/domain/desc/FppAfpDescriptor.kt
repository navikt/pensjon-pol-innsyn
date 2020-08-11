package no.nav.pensjon.innsyn.domain.desc

import no.nav.pensjon.innsyn.domain.FppAfp
import no.nav.pensjon.innsyn.entity.EntityDescriptor

object FppAfpDescriptor : EntityDescriptor<FppAfp>("FPP AFP",
        arrayOf(
                "Status",
                "Framtidige pensjonspoeng AFP",
                "Gjelder f.o.m.",
                "Gjelder t.o.m.",
                "AFP pensjonsgrad",
                "AFP type"
        )
)