package no.nav.pensjon.innsyn.entity

import no.nav.pensjon.innsyn.service.map.CellValueSetter
import no.nav.pensjon.innsyn.domain.repository.DomainRepository

abstract class DomainContainer<T>(
        val entityName: String,
        val propertyNames: Array<String>,
        val repository: DomainRepository<T>,
        val rowFiller: (CellValueSetter, T) -> Unit
)