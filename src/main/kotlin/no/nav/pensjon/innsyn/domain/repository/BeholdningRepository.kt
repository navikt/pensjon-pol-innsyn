package no.nav.pensjon.innsyn.domain.repository

import no.nav.pensjon.innsyn.domain.Beholdning
import org.springframework.stereotype.Repository

@Repository
interface BeholdningRepository : DomainRepository<Beholdning> {
    override fun findAllByPersonId(id: Int): List<Beholdning> = findAllByPersonIdOrderByDatoFom(id)
    fun findAllByPersonIdOrderByDatoFom(id: Int): List<Beholdning>
}