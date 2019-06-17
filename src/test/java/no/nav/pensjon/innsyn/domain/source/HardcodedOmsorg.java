package no.nav.pensjon.innsyn.domain.source;

import no.nav.pensjon.innsyn.domain.Omsorg;
import no.nav.pensjon.innsyn.source.EntityGetter;

import java.util.List;

public class HardcodedOmsorg implements EntityGetter<Omsorg> {

    @Override
    public List<Omsorg> getEntities() {
        return List.of(
                new Omsorg(2018, "kilde1", "type1", "status1"),
                new Omsorg(2019, "kilde2", "type2", "status2"));
    }
}
