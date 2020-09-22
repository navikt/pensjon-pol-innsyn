package no.nav.pensjon.innsyn.popp.domain

import no.nav.pensjon.innsyn.common.domain.Domain
import no.nav.pensjon.innsyn.popp.domain.support.FTjenStatus
import no.nav.pensjon.innsyn.popp.domain.support.KildeType
import no.nav.pensjon.innsyn.popp.domain.support.RapportType
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "T_F_TJEN_TOT")
data class Forstegangstjeneste(
        @Id
        @Column(name = "PERSON_ID")
        private var personId: Int,
        @Column(name = "DATO_TJENESTESTART")
        val tjenestestart: LocalDate,
        @Column(name = "DATO_DIMITTERING")
        val dimittert: LocalDate,
        @ManyToOne
        @JoinColumn(name = "K_RAPPORT_T")
        private val rapportType: RapportType,
        @ManyToOne
        @JoinColumn(name = "K_F_TJEN_TOT_S")
        private val fTjenStatus: FTjenStatus,
        @ManyToOne
        @JoinColumn(name = "K_KILDE_T")
        private val kildeType: KildeType
) : Domain {
    @get:Transient
    val rapporttype
        get() = rapportType.dekode

    @get:Transient
    val status
        get() = fTjenStatus.dekode

    @get:Transient
    val kilde
        get() = kildeType.dekode

    @get:Transient
    override val fields
        get() = setOf(::tjenestestart, ::dimittert, ::rapporttype, ::status, ::kilde)
}