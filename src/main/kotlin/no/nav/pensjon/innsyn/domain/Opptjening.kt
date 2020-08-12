package no.nav.pensjon.innsyn.domain

import javax.persistence.*

@Entity
@Table(name = "T_OPPTJN")
@SecondaryTables(
        SecondaryTable(name = "T_K_OPPTJN_T", pkJoinColumns = [PrimaryKeyJoinColumn(name = "K_OPPTJN_T")]),
        SecondaryTable(name = "T_K_OPPTJN_STATUS", pkJoinColumns = [PrimaryKeyJoinColumn(name = "K_OPPTJN_STATUS")])
)
data class Opptjening(
        @Column(name = "DEKODE", table = "T_K_OPPTJN_T")
        val type: String,
        @Column(name = "DEKODE", table = "T_K_OPPTJN_STATUS")
        val status: String,
        @Column(name = "OPPTJN_AR")
        val opptjeningsar: Int,
        @Column(name = "PGI_ANVENDT")
        val pensjonsgivendeInntekt: Double,
        @Column(name = "POENG")
        val poeng: Double,
        @Column(name = "MAX_UFOREGRAD")
        val uforegrad: Double
) {
    @Id
    @Column(name = "PERSON_ID_OPPTJN")
    var personId: Int? = null
}