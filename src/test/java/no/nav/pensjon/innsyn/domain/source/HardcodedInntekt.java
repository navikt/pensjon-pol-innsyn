package no.nav.pensjon.innsyn.domain.source;

import no.nav.pensjon.innsyn.domain.Inntekt;
import no.nav.pensjon.innsyn.source.EntityGetter;

import java.util.List;

public class HardcodedInntekt implements EntityGetter<Inntekt> {

    @Override
    public List<Inntekt> getEntities() {
        return List.of(
                new Inntekt(
                        "type",
                        "status",
                        2019,
                        123456.78d,
                        "rapportdato",
                        "kilde"));
    }
}
