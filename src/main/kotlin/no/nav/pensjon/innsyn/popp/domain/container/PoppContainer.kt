package no.nav.pensjon.innsyn.popp.domain.container

import no.nav.pensjon.innsyn.common.domain.Domain
import no.nav.pensjon.innsyn.common.domain.DomainContainer
import no.nav.pensjon.innsyn.common.repository.DomainRepository

abstract class PoppContainer<T: Domain>(
        entityName: String,
        propertyNames: Array<String>,
        repository: DomainRepository<T>
) : DomainContainer<T>(entityName, propertyNames, repository::findAllByPersonId)