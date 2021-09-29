package no.nav.pensjon.innsyn.popp.domain

import no.nav.pensjon.innsyn.common.domain.Domain
import no.nav.pensjon.innsyn.popp.domain.support.DagpengerStatus
import no.nav.pensjon.innsyn.popp.domain.support.DagpengerType
import no.nav.pensjon.innsyn.popp.domain.support.KildeType
import no.nav.pensjon.innsyn.popp.domain.support.RapportType
import javax.persistence.*

@Entity
@Table(name = "T_DAGPENGER")
data class Dagpenger(
        @Id
        @Column(name = "DAGPENGER_ID")
        val id: Int,
        @Column(name = "PERSON_ID")
        val personId: Int,
        @Column(name = "FERIETILLEGG")
        val ferietillegg: Double?,
        @Column(name = "BARNETILLEGG")
        val barnetillegg: Double?,
        @Column(name = "DAGPENGER")
        val dagpenger: Double,
        @Column(name = "UAVKORTET_DP_GRLAG")
        val uavkortetGrunnlag: Double?,
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
    @get:Transient
    val kilde
        get() = kildeType.dekode

    @get:Transient
    val status
        get() = dagpengerStatus.dekode

    @get:Transient
    val type
        get() = dagpengerType.dekode

    @get:Transient
    val rapporttype
        get() = rapportType.dekode

    @get:Transient
    override val fields
        get() = setOf(::ferietillegg, ::barnetillegg, ::dagpenger, ::uavkortetGrunnlag, ::arDagpengerUtbetalt,
                ::kilde, ::status, ::type, ::rapporttype)
}