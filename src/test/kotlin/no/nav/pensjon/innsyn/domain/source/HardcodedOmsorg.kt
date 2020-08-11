package no.nav.pensjon.innsyn.domain.source

import no.nav.pensjon.innsyn.domain.Omsorg
import no.nav.pensjon.innsyn.source.EntityGetter

class HardcodedOmsorg : EntityGetter<Omsorg?> {
    override val entities = listOf(
                Omsorg(2018, "kilde1", "type1", "status1"),
                Omsorg(2019, "kilde2", "type2", "status2"))
}