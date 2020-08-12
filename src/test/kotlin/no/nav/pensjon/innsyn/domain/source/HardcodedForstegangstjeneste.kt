package no.nav.pensjon.innsyn.domain.source

import no.nav.pensjon.innsyn.domain.Forstegangstjeneste

class HardcodedForstegangstjeneste : EntityGetter<Forstegangstjeneste?> {
    override val entities: List<Forstegangstjeneste>
        get() = java.util.List.of(
                Forstegangstjeneste(
                        "tjenestestart",
                        "dimittert",
                        "rapporttype",
                        "status",
                        "kilde"))
}