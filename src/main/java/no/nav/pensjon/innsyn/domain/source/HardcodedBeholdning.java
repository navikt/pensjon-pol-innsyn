package no.nav.pensjon.innsyn.domain.source;

import no.nav.pensjon.innsyn.domain.Beholdning;
import no.nav.pensjon.innsyn.source.EntityGetter;

import java.util.List;

public class HardcodedBeholdning implements EntityGetter<Beholdning> {

    @Override
    public List<Beholdning> getEntities() {
        return List.of(
                new Beholdning(
                        "datoFom",
                        "datoTom",
                        123456.78d,
                        "beholdningstype",
                        "status",
                        123456.78d,
                        123456.78d,
                        123456.78d,
                        2019,
                        123456.78d,
                        2019,
                        "ordinareDagpenger",
                        2019,
                        "dagpengerFisker",
                        2019,
                        123456.78d,
                        123456.78d,
                        123456.78d,
                        2019,
                        "uforegrad",
                        "uforeYrkesskadegrad",
                        "uforeAntattInntektYrke",
                        "uforeYrkesskade",
                        "uforeUforetrygd",
                        2019,
                        123456.78d,
                        123456.78d,
                        "reguleringDato"));
    }
}
