package no.nav.pensjon.innsyn.domain.tp.container

import no.nav.pensjon.innsyn.domain.tp.Forhold
import no.nav.pensjon.innsyn.domain.tp.Ytelse
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

@Component
@Profile("TP")
class YtelseContainer(forholdContainer: ForholdContainer) : TpContainer<Ytelse>("Ytelse",
        arrayOf(
                "NAVN",
                "DATO_INNM_YTEL_FOM",
                "DATO_YTEL_IVER_FOM",
                "DATO_YTEL_IVER_TOM",
                "DATO_OPPRETTET",
                "DATO_ENDRET",
                "DATO_BRUK_FOM",
                "DATO_BRUK_TOM"
        ),
        { pid: Int -> forholdContainer.source(pid).flatMap(Forhold::ytelser) }
)