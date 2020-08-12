package no.nav.pensjon.innsyn.domain

import javax.persistence.*

@Entity
@Table(name = "T_BEHOLDNING")
@SecondaryTables(
        SecondaryTable(name = "T_K_BEHOLDNING_T", pkJoinColumns = [PrimaryKeyJoinColumn(name = "K_BEHOLDNING_T")]),
        SecondaryTable(name = "T_K_BEHOLDNING_S", pkJoinColumns = [PrimaryKeyJoinColumn(name = "K_BEHOLDNING_S")]),
        SecondaryTable(name = "T_INNTEKT_OPPTJ", pkJoinColumns = [PrimaryKeyJoinColumn(name = "INNTEKT_OPPTJ_ID")]),
        SecondaryTable(name = "T_F_TJEN_OPPTJ", pkJoinColumns = [PrimaryKeyJoinColumn(name = "F_TJEN_OPPTJ_ID")]),
        SecondaryTable(name = "T_DAGPENGER_OPPTJ", pkJoinColumns = [PrimaryKeyJoinColumn(name = "DAGPENGER_OPPTJ_ID")]),
        SecondaryTable(name = "T_OMSORG_OPPTJ", pkJoinColumns = [PrimaryKeyJoinColumn(name = "OMSORG_OPPTJ_ID")]),
        SecondaryTable(name = "T_UFORE_OPPTJ", pkJoinColumns = [PrimaryKeyJoinColumn(name = "UFORE_OPPTJ_ID")]),
        SecondaryTable(name = "T_LONN_VEKST_REG", pkJoinColumns = [PrimaryKeyJoinColumn(name = "LONNSVEKST_REG_ID")])
)
data class Beholdning(
        @Column(name = "DATO_FOM")
        val datoFom: String,
        @Column(name = "DATO_TOM")
        val datoTom: String,
        @Column(name = "BELOP")
        val belop: Double,
        @Column(name = "DEKODE", table = "T_K_BEHOLDNING_T")
        val beholdningstype: String,
        @Column(name = "DEKODE", table = "T_K_BEHOLDNING_S")
        val status: String,
        @Column(name = "BEH_GRLAG")
        val grunnlag: Double,
        @Column(name = "BEH_GRLAG_AVKORTET")
        val grunnlagAvkortet: Double,
        @Column(name = "BEH_INNSKUDD")
        val innskudd: Double,
        @Column(name = "AR", table = "T_INNTEKT_OPPTJ")
        val inntektsar: Int,
        @Column(name = "BELOP", table = "T_INNTEKT_OPPTJ")
        val inntektsgrunnlag: Double,
        @Column(name = "AR", table = "T_F_TJEN_OPPTJ")
        val forstegangstjenesteAr: Int,
        @Column(name = "BELOP_ORDINAR", table = "T_DAGPENGER_OPPTJ")
        val ordinareDagpenger: Double,
        @Column(name = "AR", table = "T_DAGPENGER_OPPTJ")
        val dagpengerAr: Int,
        @Column(name = "BELOP_FISKERE", table = "T_DAGPENGER_OPPTJ")
        val dagpengerFisker: Double,
        @Column(name = "AR", table = "T_OMSORG_OPPTJ")
        val omsorgAr: Int,
        @Column(name = "BELOP", table = "T_OMSORG_OPPTJ")
        val omsorgBelop: Double,
        @Column(name = "OMS_OPPTJ_INNSKUDD", table = "T_OMSORG_OPPTJ")
        val omsorgInnskudd: Double,
        @Column(name = "BELOP", table = "T_UFORE_OPPTJ")
        val uforeBelop: Double,
        @Column(name = "AR", table = "T_UFORE_OPPTJ")
        val uforeAr: Int,
        @Column(name = "UFG", table = "T_UFORE_OPPTJ")
        val uforegrad: Double,
        @Column(name = "YUG", table = "T_UFORE_OPPTJ")
        val uforeYrkesskadegrad: Double,
        @Column(name = "ANNTATT_INNTEKT_YRKE", table = "T_UFORE_OPPTJ")
        val uforeAntattInntektYrke: Double,
        @Column(name = "YRKESSKADE", table = "T_UFORE_OPPTJ", columnDefinition = "INT(1)")
        val uforeYrkesskade: Boolean,
        @Column(name = "UFORETRYGD", table = "T_UFORE_OPPTJ", columnDefinition = "INT(1)")
        val uforeUforetrygd: Boolean,
        @Column(name = "UFOREAR", table = "T_UFORE_OPPTJ", columnDefinition = "INT(1)")
        val uforeUforeAr: Boolean,
        @Column(name = "ANNTATT_INNTEKT", table = "T_UFORE_OPPTJ")
        val uforeAntattInntekt: Double,
        @Column(name = "BELOP", table = "T_LONN_VEKST_REG")
        val reguleringBelop: Double,
        @Column(name = "REGULERING_DATO", table = "T_LONN_VEKST_REG")
        val reguleringDato: String
) {
    @Id
    @Column(name = "PERSON_ID")
    var personId: Int? = null
}