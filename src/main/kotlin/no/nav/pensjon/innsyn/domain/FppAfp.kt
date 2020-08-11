package no.nav.pensjon.innsyn.domain

import org.springframework.core.annotation.Order

/**
 * FPP = Framtidige pensjonspoeng
 * AFP = Avtalefestet pensjon
 */
data class FppAfp(val status: String,
                  val fppAfp: Double,
                  val gjelderFom: String,
                  val gjelderTom: String,
                  val afpPensjonsgrad: Double,
                  val afpType: String)