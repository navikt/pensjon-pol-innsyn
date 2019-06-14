package no.nav.pensjon.innsyn.domain.source;

import no.nav.pensjon.innsyn.domain.FppAfp;
import no.nav.pensjon.innsyn.source.EntityGetter;

import java.util.List;

public class HardcodedFppAfp implements EntityGetter<FppAfp> {

    @Override
    public List<FppAfp> getEntities() {
        return List.of(
                new FppAfp(
                        "status",
                        123456.78d,
                        "gjelderFom",
                        "gjelderTom",
                        123456.78d,
                        "afpType"));
    }
}
