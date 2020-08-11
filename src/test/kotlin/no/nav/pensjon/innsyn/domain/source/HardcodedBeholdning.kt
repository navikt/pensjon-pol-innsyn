package no.nav.pensjon.innsyn.domain.source

import no.nav.pensjon.innsyn.domain.Beholdning
import no.nav.pensjon.innsyn.source.EntityGetter

class HardcodedBeholdning : EntityGetter<Beholdning?> {
    override val entities = listOf(
                Beholdning(
                        "01.01.01",
                        "31.12.29",
                        1.23,
                        "beholdningstype",
                        "status",
                        2.34,
                        3.45,
                        4.56,
                        2011,
                        5.67,
                        2012,
                        6.78,
                        2013,
                        7.89,
                        2014,
                        8.90,
                        9.01,
                        10.12,
                        2015,
                        11.23,
                        12.34,
                        13.45,
                        true,
                        false,
                        true,
                        14.56,
                        15.67,
                        "15.06.15"))
}