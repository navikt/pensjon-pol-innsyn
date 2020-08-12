package no.nav.pensjon.innsyn.domain.source

import no.nav.pensjon.innsyn.domain.Inntekt

class HardcodedInntekt : EntityGetter<Inntekt?> {
    override val entities = listOf(
                Inntekt(
                        "type",
                        "status",
                        2019,
                        123456.78,
                        "rapportdato",
                        "kilde"))
}