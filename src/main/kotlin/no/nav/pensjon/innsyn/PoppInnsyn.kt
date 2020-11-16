package no.nav.pensjon.innsyn

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableJpaRepositories("no.nav.pensjon.innsyn.popp.repository")
@SpringBootApplication
class PoppInnsyn{
    companion object{
        @JvmStatic
        fun main(vararg args: String) {
            runApplication<PoppInnsyn>(*args)
        }
    }
}