package no.nav.pensjon.innsyn.domain.source;

import no.nav.pensjon.innsyn.domain.Opptjening;
import no.nav.pensjon.innsyn.source.EntityGetter;

import java.util.List;

public class HardcodedOpptjening implements EntityGetter<Opptjening> {

    @Override
    public List<Opptjening> getEntities() {
        return List.of(
                new Opptjening(
                        "type",
                        "status",
                        2019,
                        123456.78d,
                        12.34d,
                        15.75d));
    }
}
