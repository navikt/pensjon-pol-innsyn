package no.nav.pensjon.innsyn.domain.source;

import no.nav.pensjon.innsyn.domain.Dagpenger;
import no.nav.pensjon.innsyn.source.EntityGetter;

import java.util.List;

public class HardcodedDagpenger implements EntityGetter<Dagpenger> {

    @Override
    public List<Dagpenger> getEntities() {
        return List.of(
                new Dagpenger(
                        123456.78d,
                        123456.78d,
                        123456.78d,
                        123456.78d,
                        2019,
                        "kilde",
                        "status",
                        "type",
                        "rapporttype"));
    }
}
