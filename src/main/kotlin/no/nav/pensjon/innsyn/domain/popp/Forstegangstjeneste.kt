package no.nav.pensjon.innsyn.domain.popp

import no.nav.pensjon.innsyn.domain.Domain
import no.nav.pensjon.innsyn.domain.popp.support.FTjenStatus
import no.nav.pensjon.innsyn.domain.popp.support.KildeType
import no.nav.pensjon.innsyn.domain.popp.support.RapportType
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
): Domain {
    @Transient
    val rapporttype = rapportType.dekode
    @Transient
    val status = fTjenStatus.dekode
    @Transient
    val kilde = kildeType.dekode
    @Transient
    override val fields = setOf(::tjenestestart, ::dimittert, ::rapporttype, ::status, ::kilde)
}