package no.nav.pensjon.innsyn.domain.repository

import no.nav.pensjon.innsyn.domain.Inntekt
import org.springframework.stereotype.Repository

@Repository
interface InntektRepository : DomainRepository<Inntekt> {
    fun findAllByPersonIdOrderByInntektsarOrderByStatus(id:Int): List<Inntekt>
    override fun findAllByPersonId(id: Int): List<Inntekt> = findAllByPersonIdOrderByInntektsarOrderByStatus(id)
}