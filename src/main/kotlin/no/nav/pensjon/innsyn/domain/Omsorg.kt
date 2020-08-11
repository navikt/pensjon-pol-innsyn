package no.nav.pensjon.innsyn.domain

import org.springframework.core.annotation.Order

data class Omsorg(val ar: Int,
                  val kilde: String,
                  val type: String,
                  val status: String)