package no.nav.pensjon.innsyn.domain.source

import no.nav.pensjon.innsyn.domain.Opptjening

class HardcodedOpptjening : EntityGetter<Opptjening?> {
    override val entities = listOf(
                Opptjening(
                        "type",
                        "status",
                        2019,
                        123456.78,
                        12.34,
                        15.75))
}