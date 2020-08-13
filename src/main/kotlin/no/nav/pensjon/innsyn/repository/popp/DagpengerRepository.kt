package no.nav.pensjon.innsyn.repository.popp

import no.nav.pensjon.innsyn.domain.popp.Dagpenger
import no.nav.pensjon.innsyn.repository.DomainRepository
import org.springframework.stereotype.Repository

@Repository
interface DagpengerRepository : DomainRepository<Dagpenger>