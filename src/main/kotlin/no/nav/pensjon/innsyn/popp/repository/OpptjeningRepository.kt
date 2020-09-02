package no.nav.pensjon.innsyn.popp.repository

import no.nav.pensjon.innsyn.popp.domain.Opptjening
import no.nav.pensjon.innsyn.common.repository.DomainRepository
import org.springframework.stereotype.Repository

@Repository
interface OpptjeningRepository : DomainRepository<Opptjening> {
    fun findAllByPersonIdOrderByOpptjeningsarAscOpptjeningStatus(id: Int): List<Opptjening>
    override fun findAllByPersonId(id: Int): List<Opptjening> = findAllByPersonIdOrderByOpptjeningsarAscOpptjeningStatus(id)
}