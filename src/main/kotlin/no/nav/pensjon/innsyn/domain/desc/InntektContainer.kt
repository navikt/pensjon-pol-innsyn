package no.nav.pensjon.innsyn.domain.desc

import no.nav.pensjon.innsyn.domain.Inntekt
import no.nav.pensjon.innsyn.service.map.DomainRowFiller
import no.nav.pensjon.innsyn.domain.repository.InntektRepository
import no.nav.pensjon.innsyn.entity.PoppContainer
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
        repository,
        DomainRowFiller(Inntekt::class)::setCellValues
)