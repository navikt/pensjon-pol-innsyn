package no.nav.pensjon.innsyn.domain

import org.springframework.core.annotation.Order

data class Forstegangstjeneste(val tjenestestart: String,
                               val dimittert: String,
                               val rapporttype: String,
                               val status: String,
                               val kilde: String)