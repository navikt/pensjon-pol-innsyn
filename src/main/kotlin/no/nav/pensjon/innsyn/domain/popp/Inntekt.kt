package no.nav.pensjon.innsyn.domain.popp

import javax.persistence.*

@Entity
@Table(name = "T_INNTEKT")
@SecondaryTables(
        SecondaryTable(name = "T_K_INNTEKT_T", pkJoinColumns = [PrimaryKeyJoinColumn(name = "K_INNTEKT_T")]),
        SecondaryTable(name = "T_K_INNTEKT_STATUS", pkJoinColumns = [PrimaryKeyJoinColumn(name = "K_INNTEKT_STATUS")]),
        SecondaryTable(name = "T_K_KILDE_T", pkJoinColumns = [PrimaryKeyJoinColumn(name = "K_KILDE_T")])
)
data class Inntekt(
        @Column(name = "DEKODE", table = "T_K_INNTEKT_T")
        val type: String,
        @Column(name = "DEKODE", table = "T_K_INNTEKT_STATUS")
        val status: String,
        @Column(name = "INNTEKT_AR")
        val inntektsar: Int,
        @Column(name = "BELOP")
        val belop: Double,
        @Column(name = "PI_RAPPDATO")
        val rapportdato: String,
        @Column(name = "DEKODE", table = "T_K_KILDE_T")
        val kilde: String
) {
    @Id
    @Column(name = "PERSON_ID")
    var personId: Int? = null
}