package no.nav.pensjon.innsyn.domain.desc

import no.nav.pensjon.innsyn.domain.Opptjening
import no.nav.pensjon.innsyn.entity.EntityDescriptor

object OpptjeningDescriptor : EntityDescriptor<Opptjening>("Opptjening",
        arrayOf(
                "Type",
                "Status",
                "Opptjeningsår",
                "Pensjonsgivende inntekt",
                "Poeng",
                "Uføregrad"
        )
)