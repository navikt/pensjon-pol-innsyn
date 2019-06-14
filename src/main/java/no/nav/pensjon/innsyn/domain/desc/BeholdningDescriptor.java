package no.nav.pensjon.innsyn.domain.desc;

import no.nav.pensjon.innsyn.entity.EntityDescriptor;

public class BeholdningDescriptor implements EntityDescriptor {

    private static final String ENTITY_NAME = "Beholdning";

    private static final String[] PROPERTY_NAMES = {
            "Beholdning f.o.m.",
            "Beholdning t.o.m.",
            "Beholdning",
            "Beholdningstype",
            "Status",
            "Beholdningsgrunnlag",
            "Beholdningsgrunnlaget avkortet",
            "Beholdninginnskudd",
            "Inntektsår",
            "Inntektsgrunnlag",
            "Førstegangstjeneste, år",
            "Ordinære dagpenger",
            "Dagpenger, år",
            "Dagpenger fisker",
            "Omsorg, år",
            "Omsorg, beløp",
            "Omsorg, innskudd",
            "Uføre, beløp",
            "Uføre, år",
            "Uføregrad",
            "Uføre, yrkesskadegrad",
            "Uføre, antatt inntekt, yrke",
            "Uføre, yrkesskade",
            "Uføre, uføretrygd",
            "Uføre, uføreår",
            "Uføre, antatt inntekt",
            "Regulering, beløp",
            "Regulering, dato"
    };

    public String getEntityName() {
        return ENTITY_NAME;
    }

    public String[] getPropertyNames() {
        return PROPERTY_NAMES;
    }
}
