package no.nav.pensjon.innsyn.domain.popp

import no.nav.pensjon.innsyn.domain.Domain
import no.nav.pensjon.innsyn.domain.popp.support.DagpengerStatus
import no.nav.pensjon.innsyn.domain.popp.support.DagpengerType
import no.nav.pensjon.innsyn.domain.popp.support.KildeType
import no.nav.pensjon.innsyn.domain.popp.support.RapportType
import javax.persistence.*
import kotlin.jvm.Transient

@Entity
@Table(name = "T_DAGPENGER")
data class Dagpenger(
        @Id
        @Column(name = "PERSON_ID")
        val personId: Int,
        @Column(name = "FERIETILLEGG")
        val ferietillegg: Double,
        @Column(name = "BARNETILLEGG")
        val barnetillegg: Double,
        @Column(name = "DAGPENGER")
        val dagpenger: Double,
        @Column(name = "UAVKORTET_DP_GRLAG")
        val uavkortetGrunnlag: Double,
        @Column(name = "AR")
        val arDagpengerUtbetalt: Int,
        @ManyToOne
        @JoinColumn(name = "K_KILDE_T")
        private val kildeType: KildeType,
        @ManyToOne
        @JoinColumn(name = "K_DAGPENGER_S")
        private val dagpengerStatus: DagpengerStatus,
        @ManyToOne
        @JoinColumn(name = "K_DAGPENGER_T")
        private val dagpengerType: DagpengerType,
        @ManyToOne
        @JoinColumn(name = "K_RAPPORT_T")
        private val rapportType: RapportType

) : Domain {
    @Transient
    val kilde = kildeType.dekode

    @Transient
    val status = dagpengerStatus.dekode

    @Transient
    val type = dagpengerType.dekode

    @Transient
    val rapporttype = rapportType.dekode

    @Transient
    override val fields = setOf(::ferietillegg, ::barnetillegg, ::dagpenger, ::uavkortetGrunnlag, ::arDagpengerUtbetalt,
            ::kilde, ::status, ::type, ::rapporttype)
}