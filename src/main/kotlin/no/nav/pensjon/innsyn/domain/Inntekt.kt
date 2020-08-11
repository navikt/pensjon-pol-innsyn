package no.nav.pensjon.innsyn.domain

import org.springframework.core.annotation.Order

data class Inntekt(val type: String,
                   val status: String,
                   val inntektsar: Int,
                   val belop: Double,
                   val rapportdato: String,
                   val kilde: String)