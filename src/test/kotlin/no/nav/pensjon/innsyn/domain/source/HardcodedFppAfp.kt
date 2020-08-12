package no.nav.pensjon.innsyn.domain.source

import no.nav.pensjon.innsyn.domain.FppAfp

class HardcodedFppAfp : EntityGetter<FppAfp?> {
    override val entities = listOf(
                FppAfp(
                        "status",
                        123456.78,
                        "gjelderFom",
                        "gjelderTom",
                        123456.78,
                        "afpType"))
}