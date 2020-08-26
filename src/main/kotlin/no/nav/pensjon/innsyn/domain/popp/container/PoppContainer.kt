package no.nav.pensjon.innsyn.domain.popp.container

import no.nav.pensjon.innsyn.domain.Domain
import no.nav.pensjon.innsyn.domain.DomainContainer
import no.nav.pensjon.innsyn.repository.DomainRepository

abstract class PoppContainer<T: Domain>(
        entityName: String,
        propertyNames: Array<String>,
        repository: DomainRepository<T>
) : DomainContainer<T>(entityName, propertyNames, repository::findAllByPersonId)