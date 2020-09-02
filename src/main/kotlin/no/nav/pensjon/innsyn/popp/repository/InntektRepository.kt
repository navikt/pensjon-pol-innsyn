package no.nav.pensjon.innsyn.popp.repository

import no.nav.pensjon.innsyn.popp.domain.Inntekt
import no.nav.pensjon.innsyn.common.repository.DomainRepository
import org.springframework.stereotype.Repository

@Repository
interface InntektRepository : DomainRepository<Inntekt> {
    fun findAllByPersonIdOrderByInntektsarAscInntektStatus(id:Int): List<Inntekt>
    override fun findAllByPersonId(id: Int): List<Inntekt> = findAllByPersonIdOrderByInntektsarAscInntektStatus(id)
}