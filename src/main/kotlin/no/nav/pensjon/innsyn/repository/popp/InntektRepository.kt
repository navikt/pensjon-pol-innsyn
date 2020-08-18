package no.nav.pensjon.innsyn.repository.popp

import no.nav.pensjon.innsyn.domain.popp.Inntekt
import no.nav.pensjon.innsyn.repository.DomainRepository
import org.springframework.stereotype.Repository

@Repository
interface InntektRepository : DomainRepository<Inntekt> {
    fun findAllByPersonIdOrderByInntektsarAscInntektStatus(id:Int): List<Inntekt>
    override fun findAllByPersonId(id: Int): List<Inntekt> = findAllByPersonIdOrderByInntektsarAscInntektStatus(id)
}