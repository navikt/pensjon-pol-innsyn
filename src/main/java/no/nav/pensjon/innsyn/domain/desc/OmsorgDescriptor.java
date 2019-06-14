package no.nav.pensjon.innsyn.domain.desc;

import no.nav.pensjon.innsyn.entity.EntityDescriptor;

public class OmsorgDescriptor implements EntityDescriptor {

    private static final String ENTITY_NAME = "Omsorg";

    private static final String[] PROPERTY_NAMES = {
            "År",
            "Kilde",
            "Type",
            "Status"
    };

    public String getEntityName() {
        return ENTITY_NAME;
    }

    public String[] getPropertyNames() {
        return PROPERTY_NAMES;
    }
}
