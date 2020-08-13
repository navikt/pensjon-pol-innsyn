package no.nav.pensjon.innsyn.domain.popp

import javax.persistence.*

@Entity
@Table(name = "T_DAGPENGER")
@SecondaryTables(
        SecondaryTable(name = "T_K_KILDE_T", pkJoinColumns = [PrimaryKeyJoinColumn(name = "K_KILDE_T")]),
        SecondaryTable(name = "T_K_DAGPENGER_S", pkJoinColumns = [PrimaryKeyJoinColumn(name = "K_DAGPENGER_S")]),
        SecondaryTable(name = "T_K_DAGPENGER_T", pkJoinColumns = [PrimaryKeyJoinColumn(name = "K_DAGPENGER_T")]),
        SecondaryTable(name = "T_K_RAPPORT_T", pkJoinColumns = [PrimaryKeyJoinColumn(name = "K_RAPPORT_T")])
)
data class Dagpenger(
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
        @Column(name = "DEKODE", table = "T_K_KILDE_T")
        val kilde: String,
        @Column(name = "DEKODE", table = "T_K_DAGPENGER_S")
        val status: String,
        @Column(name = "DEKODE", table = "T_K_DAGPENGER_T")
        val type: String,
        @Column(name = "DEKODE", table = "T_K_RAPPORT_T")
        val rapporttype: String
) {
    @Id
    @Column(name = "PERSON_ID")
    var personId: Int? = null
}