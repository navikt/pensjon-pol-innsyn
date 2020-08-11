package no.nav.pensjon.innsyn.domain

import org.springframework.core.annotation.Order

data class Opptjening(val type: String,
                      val status: String,
                      val opptjeningsar: Int,
                      val pensjonsgivendeInntekt: Double,
                      val poeng: Double,
                      val uforegrad: Double)