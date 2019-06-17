package no.nav.pensjon.innsyn.domain.source;

import no.nav.pensjon.innsyn.domain.Forstegangstjeneste;
import no.nav.pensjon.innsyn.source.EntityGetter;

import java.util.List;

public class HardcodedForstegangstjeneste implements EntityGetter<Forstegangstjeneste> {

    @Override
    public List<Forstegangstjeneste> getEntities() {
        return List.of(
                new Forstegangstjeneste(
                        "tjenestestart",
                        "dimittert",
                        "rapporttype",
                        "status",
                        "kilde"));
    }
}
