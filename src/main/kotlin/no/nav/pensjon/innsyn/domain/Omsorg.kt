package no.nav.pensjon.innsyn.domain

import javax.persistence.*

@Entity
@Table(name = "T_OMSORG")
@SecondaryTables(
        SecondaryTable(name = "T_K_KILDE_T", pkJoinColumns = [PrimaryKeyJoinColumn(name = "K_KILDE_T")]),
        SecondaryTable(name = "T_K_OMSORG_T", pkJoinColumns = [javax.persistence.PrimaryKeyJoinColumn(name = "K_OMSORG_T")]),
        SecondaryTable(name = "T_K_OMSORG_S", pkJoinColumns = [javax.persistence.PrimaryKeyJoinColumn(name = "K_OMSORG_S")])
)
data class Omsorg(
        @Column(name = "AR")
        val ar: Int,
        @Column(name = "DEKODE", table = "T_K_KILDE_T")
        val kilde: String,
        @Column(name = "DEKODE", table = "T_K_OMSORG_T")
        val type: String,
        @Column(name = "DEKODE", table = "T_K_OMSORG_S")
        val status: String
) {
    @Id
    @Column(name = "PERSON_ID")
    var personId: Int? = null
}