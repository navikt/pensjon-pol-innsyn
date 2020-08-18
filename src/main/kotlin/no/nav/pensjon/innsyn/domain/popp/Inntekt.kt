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
): Domain {
    @Transient
    val type = inntektType.dekode
    @Transient
    val status = inntektStatus.dekode
    @Transient
    val kilde = kildeType.dekode
    @Transient
    override val fields = setOf(::type, ::status, ::inntektsar, ::belop, ::rapportdato, ::kilde)
}