package no.nav.pensjon.innsyn.popp.repository

import no.nav.pensjon.innsyn.common.repository.DomainRepository
import no.nav.pensjon.innsyn.popp.domain.Beholdning
import org.springframework.stereotype.Repository

@Repository
interface BeholdningRepository : DomainRepository<Beholdning> {
    fun findAllByPersonIdOrderByDatoFom(id: Int): List<Beholdning>
    override fun findAllByPersonId(id: Int): List<Beholdning> = findAllByPersonIdOrderByDatoFom(id)
}