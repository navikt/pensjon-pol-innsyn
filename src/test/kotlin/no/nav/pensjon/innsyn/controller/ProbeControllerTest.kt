package no.nav.pensjon.innsyn.controller

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@WebMvcTest(ProbeController::class)
@ActiveProfiles("test")
internal class ProbeControllerTest {
    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun isAlive() {
        mockMvc.get("/isAlive").andExpect {
            status { isOk }
        }
    }

    @Test
    fun isReady() {
        mockMvc.get("/isReady").andExpect {
            status { isOk }
        }
    }
}