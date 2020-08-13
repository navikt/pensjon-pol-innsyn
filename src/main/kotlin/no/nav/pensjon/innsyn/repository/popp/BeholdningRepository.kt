package no.nav.pensjon.innsyn.repository.popp

import no.nav.pensjon.innsyn.domain.popp.Beholdning
import no.nav.pensjon.innsyn.repository.DomainRepository
import org.springframework.stereotype.Repository

@Repository
interface BeholdningRepository : DomainRepository<Beholdning> {
    fun findAllByPersonIdOrderByDatoFom(id: Int): List<Beholdning>
    override fun findAllByPersonId(id: Int): List<Beholdning> = findAllByPersonIdOrderByDatoFom(id)
}