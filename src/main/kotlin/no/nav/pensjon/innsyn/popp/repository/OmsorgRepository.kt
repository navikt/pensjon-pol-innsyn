package no.nav.pensjon.innsyn.popp.repository

import no.nav.pensjon.innsyn.common.repository.DomainRepository
import no.nav.pensjon.innsyn.popp.domain.Omsorg
import org.springframework.stereotype.Repository

@Repository
interface OmsorgRepository : DomainRepository<Omsorg>