package no.nav.pensjon.innsyn.domain.popp

import javax.persistence.*

/**
 * FPP = Framtidige pensjonspoeng
 * AFP = Avtalefestet pensjon
 */
@Entity
@Table(name = "T_FPP_AFP")
@SecondaryTable(name = "T_K_FPP_AFP_S", pkJoinColumns = [PrimaryKeyJoinColumn(name = "K_FPP_AFP_S")])
data class FppAfp(
        @Column(name = "DEKODE", table = "T_K_FPP_AFP_S")
        val status: String,
        @Column(name = "AFP_FPP")
        val fppAfp: Double,
        @Column(name = "VIRK_FOM")
        val gjelderFom: String,
        @Column(name = "VIRK_TOM")
        val gjelderTom: String,
        @Column(name = "AFP_PENSJONSGRAD")
        val afpPensjonsgrad: Double,
        @Column(name = "AFP_TYPE")
        val afpType: String
) {
    @Id
    @Column(name = "PERSON_ID")
    var personId: Int? = null
}