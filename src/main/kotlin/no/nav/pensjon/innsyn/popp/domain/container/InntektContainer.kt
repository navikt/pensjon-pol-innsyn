package no.nav.pensjon.innsyn.popp.domain.container

import no.nav.pensjon.innsyn.popp.domain.Inntekt
import no.nav.pensjon.innsyn.popp.repository.InntektRepository
import org.springframework.context.annotation.Profile
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