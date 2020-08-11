package no.nav.pensjon.innsyn.domain.desc

import no.nav.pensjon.innsyn.domain.Inntekt
import no.nav.pensjon.innsyn.entity.EntityDescriptor

object InntektDescriptor : EntityDescriptor<Inntekt>("Inntekt",
        arrayOf(
                "Type",
                "Status",
                "Inntektsår",
                "Beløp",
                "Rapportdato",
                "Kilde"
        )
)