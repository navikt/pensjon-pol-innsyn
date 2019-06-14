package no.nav.pensjon.innsyn.domain.desc;

import no.nav.pensjon.innsyn.entity.EntityDescriptor;

public class OpptjeningDescriptor implements EntityDescriptor {

    private static final String ENTITY_NAME = "Opptjening";

    private static final String[] PROPERTY_NAMES = {
            "Type",
            "Status",
            "Opptjeningsår",
            "Pensjonsgivende inntekt",
            "Poeng",
            "Uføregrad"
    };

    public String getEntityName() {
        return ENTITY_NAME;
    }

    public String[] getPropertyNames() {
        return PROPERTY_NAMES;
    }
}
