package no.nav.pensjon.innsyn.domain.popp.container

import no.nav.pensjon.innsyn.domain.popp.Inntekt
import no.nav.pensjon.innsyn.repository.popp.InntektRepository
import org.springframework.stereotype.Component

@Component
class InntektContainer(repository: InntektRepository) : PoppContainer<Inntekt>("Inntekt",
        arrayOf(
                "Type",
                "Status",
                "Inntektsår",
                "Beløp",
                "Rapportdato",
                "Kilde"
        ),
        repository
)