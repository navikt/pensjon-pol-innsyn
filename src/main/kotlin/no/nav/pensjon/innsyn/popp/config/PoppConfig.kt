package no.nav.pensjon.innsyn.popp.config

import no.nav.security.token.support.spring.api.EnableJwtTokenValidation
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@EnableJwtTokenValidation
@Profile("!test")
@Configuration
class PoppConfig