package no.nav.pensjon.innsyn.config

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableJpaRepositories
@Configuration
@Profile("!test")
class InnsynConfig