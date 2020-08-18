package no.nav.pensjon.innsyn.repository.popp

import no.nav.pensjon.innsyn.domain.popp.Opptjening
import no.nav.pensjon.innsyn.repository.DomainRepository
import org.springframework.stereotype.Repository

@Repository
interface OpptjeningRepository : DomainRepository<Opptjening> {
    fun findAllByPersonIdOrderByOpptjeningsarAscOpptjeningStatus(id: Int): List<Opptjening>
    override fun findAllByPersonId(id: Int): List<Opptjening> = findAllByPersonIdOrderByOpptjeningsarAscOpptjeningStatus(id)
}