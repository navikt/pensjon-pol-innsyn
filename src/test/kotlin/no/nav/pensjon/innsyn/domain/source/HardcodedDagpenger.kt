package no.nav.pensjon.innsyn.domain.source

import no.nav.pensjon.innsyn.domain.Dagpenger

class HardcodedDagpenger : EntityGetter<Dagpenger?> {
    override val entities = listOf(
                Dagpenger(
                        123456.78,
                        123456.78,
                        123456.78,
                        123456.78,
                        2019,
                        "kilde",
                        "status",
                        "type",
                        "rapporttype"))
}