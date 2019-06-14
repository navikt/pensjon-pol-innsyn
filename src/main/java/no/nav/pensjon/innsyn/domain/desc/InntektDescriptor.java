package no.nav.pensjon.innsyn.domain.desc;

import no.nav.pensjon.innsyn.entity.EntityDescriptor;

public class InntektDescriptor implements EntityDescriptor {

    private static final String ENTITY_NAME = "Inntekt";

    private static final String[] PROPERTY_NAMES = {
            "Type",
            "Status",
            "Inntektsår",
            "Beløp",
            "Rapportdato",
            "Kilde"
    };

    public String getEntityName() {
        return ENTITY_NAME;
    }

    public String[] getPropertyNames() {
        return PROPERTY_NAMES;
    }
}
