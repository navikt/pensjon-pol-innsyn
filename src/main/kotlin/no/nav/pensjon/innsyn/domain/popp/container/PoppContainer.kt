package no.nav.pensjon.innsyn.domain.popp.container

import no.nav.pensjon.innsyn.domain.DomainContainer
import no.nav.pensjon.innsyn.service.map.CellValueSetter
import no.nav.pensjon.innsyn.repository.DomainRepository

abstract class PoppContainer<T>(
        entityName: String,
        propertyNames: Array<String>,
        repository: DomainRepository<T>,
        rowFiller: (CellValueSetter, T) -> Unit
) : DomainContainer<T>(entityName, propertyNames, repository, rowFiller)