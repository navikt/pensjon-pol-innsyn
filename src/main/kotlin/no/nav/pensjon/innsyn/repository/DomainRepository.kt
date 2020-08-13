package no.nav.pensjon.innsyn.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.NoRepositoryBean

@NoRepositoryBean
interface DomainRepository<T> : CrudRepository<T, Int> {
    fun findAllByPersonId(id: Int): List<T>
}