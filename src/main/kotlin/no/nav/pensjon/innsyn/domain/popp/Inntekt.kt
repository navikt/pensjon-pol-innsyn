package no.nav.pensjon.innsyn.domain.popp

import no.nav.pensjon.innsyn.domain.Domain
import no.nav.pensjon.innsyn.domain.popp.support.InntektStatus
import no.nav.pensjon.innsyn.domain.popp.support.InntektType
import no.nav.pensjon.innsyn.domain.popp.support.KildeType
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "T_INNTEKT")
data class Inntekt(
        @Id
        @Column(name = "PERSON_ID")
        var personId: Int,
        @ManyToOne
        @JoinColumn(name = "K_INNTEKT_T")
        val inntektType: InntektType,
        @ManyToOne
        @JoinColumn(name = "K_INNTEKT_STATUS")
        val inntektStatus: InntektStatus,
        @Column(name = "INNTEKT_AR")
        val inntektsar: Int,
        @Column(name = "BELOP")
        val belop: Double,
        @Column(name = "PI_RAPPDATO")
        val rapportdato: LocalDate,
        @ManyToOne
        @JoinColumn(name = "K_Kilde_T")
        val kildeType: KildeType
) : Domain {
    @get:Transient
    val type
        get() = inntektType.dekode

    @get:Transient
    val status
        get() = inntektStatus.dekode

    @get:Transient
    val kilde
        get() = kildeType.dekode

    @get:Transient
    override val fields
        get() = setOf(::type, ::status, ::inntektsar, ::belop, ::rapportdato, ::kilde)
}