package no.nav.pensjon.innsyn.domain.repository

import no.nav.pensjon.innsyn.domain.Opptjening
import org.springframework.stereotype.Repository

@Repository
interface OpptjeningRepository : DomainRepository<Opptjening> {
    fun findAllByPersonIdOrderByOpptjeningsarOrderByStatus(id: Int): List<Opptjening>
    override fun findAllByPersonId(id: Int): List<Opptjening> = findAllByPersonIdOrderByOpptjeningsarOrderByStatus(id)
}