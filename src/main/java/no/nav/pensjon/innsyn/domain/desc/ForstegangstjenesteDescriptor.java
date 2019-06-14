package no.nav.pensjon.innsyn.domain.desc;

import no.nav.pensjon.innsyn.entity.EntityDescriptor;

public class ForstegangstjenesteDescriptor implements EntityDescriptor {

    private static final String ENTITY_NAME = "Førstegangstjeneste";

    private static final String[] PROPERTY_NAMES = {
            "Tjenestestart",
            "Dimittert",
            "Rapporttype",
            "Status",
            "Kilde"
    };

    public String getEntityName() {
        return ENTITY_NAME;
    }

    public String[] getPropertyNames() {
        return PROPERTY_NAMES;
    }
}
