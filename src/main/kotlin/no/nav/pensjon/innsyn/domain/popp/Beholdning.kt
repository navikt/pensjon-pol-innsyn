package no.nav.pensjon.innsyn.domain.popp

import no.nav.pensjon.innsyn.domain.Domain
import no.nav.pensjon.innsyn.domain.popp.support.*
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "T_BEHOLDNING")
data class Beholdning(
        @Id
        @Column(name = "PERSON_ID")
        private val personId: Int,
        @Column(name = "DATO_FOM")
        val datoFom: LocalDate,
        @Column(name = "DATO_TOM")
        val datoTom: LocalDate,
        @Column(name = "BELOP")
        val belop: Double,
        @Column(name = "BEH_GRLAG")
        val grunnlag: Double,
        @Column(name = "BEH_GRLAG_AVKORTET")
        val grunnlagAvkortet: Double,
        @Column(name = "BEH_INNSKUDD")
        val innskudd: Double,
        @ManyToOne
        @JoinColumn(name = "K_BEHOLDNING_T")
        private val beholdningType: BeholdningType,
        @ManyToOne
        @JoinColumn(name = "K_BEHOLDNING_S")
        private val beholdningStatus: BeholdningStatus,
        @ManyToOne
        @JoinColumn(name = "INNTEKT_OPPTJ_ID")
        private val inntektOpptj: InntektOpptj,
        @ManyToOne
        @JoinColumn(name = "F_TJEN_OPPTJ_ID")
        private val fTjenOpptj: FTjenOpptj,
        @ManyToOne
        @JoinColumn(name = "DAGPENGER_OPPTJ_ID")
        var dagpengerOpptj: DagpengerOpptj,
        @ManyToOne
        @JoinColumn(name = "OMSORG_OPPTJ_ID")
        var omsorgOpptj: OmsorgOpptj,
        @ManyToOne
        @JoinColumn(name = "UFORE_OPPTJ_ID")
        var uforeOpptj: UforeOpptj,
        @ManyToOne
        @JoinColumn(name = "LONNSVEKST_REG_ID")
        var lonnsvekstReg: LonnsvekstReg
) : Domain {
    @Transient
    val beholdningstype = beholdningType.dekode
    @Transient
    val status = beholdningStatus.dekode
    @Transient
    val inntektsar = inntektOpptj.ar
    @Transient
    val inntektsgrunnlag = inntektOpptj.belop
    @Transient
    val forstegangstjenesteAr = fTjenOpptj.ar
    @Transient
    val ordinareDagpenger = dagpengerOpptj.belopOrdinar
    @Transient
    val dagpengerAr = dagpengerOpptj.ar
    @Transient
    val dagpengerFisker = dagpengerOpptj.belopFiskere
    @Transient
    val omsorgAr = omsorgOpptj.ar
    @Transient
    val omsorgBelop = omsorgOpptj.belop
    @Transient
    val omsorgInnskudd = omsorgOpptj.inskudd
    @Transient
    val uforeBelop = uforeOpptj.belop
    @Transient
    val uforeAr = uforeOpptj.ar
    @Transient
    val uforegrad = uforeOpptj.ufg
    @Transient
    val uforeYrkesskadegrad = uforeOpptj.yug
    @Transient
    val uforeAntattInntektYrke = uforeOpptj.antattInntektYrke
    @Transient
    val uforeYrkesskade = uforeOpptj.yrkesskade
    @Transient
    val uforeUforetrygd = uforeOpptj.uforetrygd
    @Transient
    val uforeUforeAr = uforeOpptj.uforear
    @Transient
    val uforeAntattInntekt = uforeOpptj.antattInntekt
    @Transient
    val reguleringBelop = lonnsvekstReg.belop
    @Transient
    val reguleringDato = lonnsvekstReg.dato

    @Transient
    override val fields = setOf(::datoFom, ::datoTom, ::belop, ::beholdningstype, ::status, ::grunnlag,
            ::grunnlagAvkortet, ::innskudd, ::inntektsar, ::inntektsgrunnlag, ::forstegangstjenesteAr,
            ::ordinareDagpenger, ::dagpengerAr, ::dagpengerFisker, ::omsorgAr, ::omsorgBelop, ::omsorgInnskudd,
            ::uforeBelop, ::uforeAr, ::uforegrad, ::uforeYrkesskadegrad, ::uforeAntattInntektYrke, ::uforeYrkesskade,
            ::uforeUforetrygd, ::uforeUforeAr, ::uforeAntattInntekt, ::reguleringBelop, ::reguleringDato)
}