package no.nav.pensjon.innsyn.domain.popp

import javax.persistence.*

@Entity
@Table(name = "T_F_TJEN_TOT")
@SecondaryTables(
        SecondaryTable(name = "T_K_RAPPORT_T", pkJoinColumns = [PrimaryKeyJoinColumn(name = "K_RAPPORT_T")]),
        SecondaryTable(name = "T_K_F_TJEN_TOT_S", pkJoinColumns = [PrimaryKeyJoinColumn(name = "K_F_TJEN_TOT_S")]),
        SecondaryTable(name = "T_K_KILDE_T", pkJoinColumns = [PrimaryKeyJoinColumn(name = "K_KILDE_T")])
)
data class Forstegangstjeneste(
        @Column(name = "DATO_TJENESTESTART")
        val tjenestestart: String,
        @Column(name = "DATO_DIMITTERING")
        val dimittert: String,
        @Column(name = "DEKODE", table = "T_K_RAPPORT_T")
        val rapporttype: String,
        @Column(name = "DEKODE", table = "T_K_F_TJEN_TOT_S")
        val status: String,
        @Column(name = "DEKODE", table = "T_K_KILDE_T")
        val kilde: String
) {
    @Id
    @Column(name = "PERSON_ID")
    var personId: Int? = null
}