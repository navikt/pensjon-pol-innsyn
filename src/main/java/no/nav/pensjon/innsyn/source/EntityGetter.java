package no.nav.pensjon.innsyn.source;

import java.util.List;

public interface EntityGetter<T> {

    List<T> getEntities();
}
