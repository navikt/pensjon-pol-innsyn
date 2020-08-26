package no.nav.pensjon.innsyn.repository.tp

import no.nav.pensjon.innsyn.domain.tp.Forhold
import no.nav.pensjon.innsyn.repository.DomainRepository
import org.springframework.stereotype.Repository

@Repository
interface ForholdRepository : DomainRepository<Forhold>