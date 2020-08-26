package no.nav.pensjon.innsyn.domain.tp.container

import no.nav.pensjon.innsyn.domain.tp.Forhold
import no.nav.pensjon.innsyn.repository.tp.ForholdRepository
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

@Component
@Profile("TP")
class ForholdContainer(repository: ForholdRepository) : TpContainer<Forhold>("Forhold",
        arrayOf(
                "NAVN",
                "DATO_SAMTYKKE_GITT",
                "DATO_OPPRETTET",
                "K_SAMTYKKE_SIM_T",
                "DATO_BRUK_FOM",
                "DATO_BRUK_TOM"
        ),
        repository::findAllByPersonId
)