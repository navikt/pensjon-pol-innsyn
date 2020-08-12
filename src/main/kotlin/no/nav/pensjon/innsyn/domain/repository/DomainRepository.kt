package no.nav.pensjon.innsyn.domain.repository

import org.springframework.data.repository.CrudRepository

interface DomainRepository<T> : CrudRepository<T, Int> {
    fun findAllByPersonId(id: Int): List<T>
}