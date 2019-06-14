package no.nav.pensjon.innsyn.domain.desc;

import no.nav.pensjon.innsyn.entity.EntityDescriptor;

public class DagpengerDescriptor implements EntityDescriptor {

    private static final String ENTITY_NAME = "Dagpenger";

    private static final String[] PROPERTY_NAMES = {
            "Ferietillegg",
            "Barnetillegg",
            "Dagpenger",
            "Uavkortet grunnlag",
            "År dagpenger utbetalt",
            "Kilde",
            "Status",
            "Type",
            "Rapporttype"
    };

    public String getEntityName() {
        return ENTITY_NAME;
    }

    public String[] getPropertyNames() {
        return PROPERTY_NAMES;
    }
}
