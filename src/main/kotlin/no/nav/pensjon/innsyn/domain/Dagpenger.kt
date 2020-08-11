package no.nav.pensjon.innsyn.domain

import org.springframework.core.annotation.Order

data class Dagpenger(val ferietillegg: Double,
                     val barnetillegg: Double,
                     val dagpenger: Double,
                     val uavkortetGrunnlag: Double,
                     val arDagpengerUtbetalt: Int,
                     val kilde: String,
                     val status: String,
                     val type: String,
                     val rapporttype: String)