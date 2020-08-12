package no.nav.pensjon.innsyn.controller

import no.nav.security.token.support.core.api.Unprotected
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServlet

@Unprotected
@RestController
class ProbeServlet : HttpServlet() {
    @get:GetMapping("/isAlive")
    val isAlive: Nothing? = null

    @get:GetMapping("/isReady")
    val isReady: Nothing? = null
}