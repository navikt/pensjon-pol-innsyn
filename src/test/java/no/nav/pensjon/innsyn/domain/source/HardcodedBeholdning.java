package no.nav.pensjon.innsyn.domain.source;

import no.nav.pensjon.innsyn.domain.Beholdning;
import no.nav.pensjon.innsyn.source.EntityGetter;

import java.util.List;

public class HardcodedBeholdning implements EntityGetter<Beholdning> {

    @Override
    public List<Beholdning> getEntities() {
        return List.of(
                new Beholdning(
                        "01.01.01",
                        "31.12.29",
                        1.23d,
                        "beholdningstype",
                        "status",
                        2.34d,
                        3.45d,
                        4.56d,
                        2011,
                        5.67d,
                        2012,
                        6.78d,
                        2013,
                        7.89d,
                        2014,
                        8.90d,
                        9.01d,
                        10.12d,
                        2015,
                        11.23d,
                        12.34d,
                        13.45d,
                        true,
                        false,
                        true,
                        14.56d,
                        15.67d,
                        "15.06.15"));
    }
}
