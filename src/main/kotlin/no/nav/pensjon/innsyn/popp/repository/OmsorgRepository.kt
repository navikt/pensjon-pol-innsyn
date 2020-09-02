package no.nav.pensjon.innsyn.popp.repository

import no.nav.pensjon.innsyn.popp.domain.Omsorg
import no.nav.pensjon.innsyn.common.repository.DomainRepository
import org.springframework.stereotype.Repository

@Repository
interface OmsorgRepository : DomainRepository<Omsorg>