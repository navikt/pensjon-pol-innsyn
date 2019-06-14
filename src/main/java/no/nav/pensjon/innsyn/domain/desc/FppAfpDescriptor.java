package no.nav.pensjon.innsyn.domain.desc;

import no.nav.pensjon.innsyn.entity.EntityDescriptor;

public class FppAfpDescriptor implements EntityDescriptor {

    private static final String ENTITY_NAME = "FPP AFP";

    private static final String[] PROPERTY_NAMES = {
            "Status",
            "Framtidige pensjonspoeng AFP",
            "Gjelder f.o.m.",
            "Gjelder t.o.m.",
            "AFP pensjonsgrad",
            "AFP type"
    };

    public String getEntityName() {
        return ENTITY_NAME;
    }

    public String[] getPropertyNames() {
        return PROPERTY_NAMES;
    }
}
