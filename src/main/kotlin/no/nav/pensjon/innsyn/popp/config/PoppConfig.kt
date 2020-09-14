package no.nav.pensjon.innsyn.popp.config

import no.nav.security.token.support.spring.api.EnableJwtTokenValidation
import org.springframework.context.annotation.Profile
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableJpaRepositories
@EnableJwtTokenValidation
@Profile("!test")
class PoppConfig