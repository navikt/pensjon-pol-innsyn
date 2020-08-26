package no.nav.pensjon.innsyn.domain.tp.container

import no.nav.pensjon.innsyn.domain.Domain
import no.nav.pensjon.innsyn.domain.DomainContainer

abstract class TpContainer<T: Domain>(
        entityName: String,
        propertyNames: Array<String>,
        source: (Int) -> List<T>
) : DomainContainer<T>(entityName, propertyNames, source)