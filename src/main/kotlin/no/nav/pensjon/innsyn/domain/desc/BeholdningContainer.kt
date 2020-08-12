package no.nav.pensjon.innsyn.domain.desc

import no.nav.pensjon.innsyn.domain.Beholdning
import no.nav.pensjon.innsyn.service.map.DomainRowFiller
import no.nav.pensjon.innsyn.domain.repository.BeholdningRepository
import no.nav.pensjon.innsyn.entity.PoppContainer
import org.springframework.stereotype.Component

@Component
class BeholdningContainer(repository: BeholdningRepository) : PoppContainer<Beholdning>("Beholdning",
        arrayOf(
                "Beholdning f.o.m.",
                "Beholdning t.o.m.",
                "Beholdning",
                "Beholdningstype",
                "Status",
                "Beholdningsgrunnlag",
                "Beholdningsgrunnlaget avkortet",
                "Beholdninginnskudd",
                "Inntektsår",
                "Inntektsgrunnlag",
                "Førstegangstjeneste, år",
                "Ordinære dagpenger",
                "Dagpenger, år",
                "Dagpenger fisker",
                "Omsorg, år",
                "Omsorg, beløp",
                "Omsorg, innskudd",
                "Uføre, beløp",
                "Uføre, år",
                "Uføregrad",
                "Uføre, yrkesskadegrad",
                "Uføre, antatt inntekt, yrke",
                "Uføre, yrkesskade",
                "Uføre, uføretrygd",
                "Uføre, uføreår",
                "Uføre, antatt inntekt",
                "Regulering, beløp",
                "Regulering, dato"
        ),
        repository,
        DomainRowFiller(Beholdning::class)::setCellValues
)