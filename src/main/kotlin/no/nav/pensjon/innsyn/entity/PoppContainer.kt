package no.nav.pensjon.innsyn.entity

import no.nav.pensjon.innsyn.service.map.CellValueSetter
import no.nav.pensjon.innsyn.domain.repository.DomainRepository

abstract class PoppContainer<T>(
        entityName: String,
        propertyNames: Array<String>,
        repository: DomainRepository<T>,
        rowFiller: (CellValueSetter, T) -> Unit
) : DomainContainer<T>(entityName, propertyNames, repository, rowFiller)