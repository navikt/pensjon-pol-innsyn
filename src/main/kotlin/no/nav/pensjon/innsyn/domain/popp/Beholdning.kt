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
    @get:Transient
    val beholdningstype
        get() = beholdningType.dekode

    @get:Transient
    val status
        get() = beholdningStatus.dekode

    @get:Transient
    val inntektsar
        get() = inntektOpptj.ar

    @get:Transient
    val inntektsgrunnlag
        get() = inntektOpptj.belop

    @get:Transient
    val forstegangstjenesteAr
        get() = fTjenOpptj.ar

    @get:Transient
    val ordinareDagpenger
        get() = dagpengerOpptj.belopOrdinar

    @get:Transient
    val dagpengerAr
        get() = dagpengerOpptj.ar

    @get:Transient
    val dagpengerFisker
        get() = dagpengerOpptj.belopFiskere

    @get:Transient
    val omsorgAr
        get() = omsorgOpptj.ar

    @get:Transient
    val omsorgBelop
        get() = omsorgOpptj.belop

    @get:Transient
    val omsorgInnskudd
        get() = omsorgOpptj.inskudd

    @get:Transient
    val uforeBelop
        get() = uforeOpptj.belop

    @get:Transient
    val uforeAr
        get() = uforeOpptj.ar

    @get:Transient
    val uforegrad
        get() = uforeOpptj.ufg

    @get:Transient
    val uforeYrkesskadegrad
        get() = uforeOpptj.yug

    @get:Transient
    val uforeAntattInntektYrke
        get() = uforeOpptj.antattInntektYrke

    @get:Transient
    val uforeYrkesskade
        get() = uforeOpptj.yrkesskade

    @get:Transient
    val uforeUforetrygd
        get() = uforeOpptj.uforetrygd

    @get:Transient
    val uforeUforeAr
        get() = uforeOpptj.uforear

    @get:Transient
    val uforeAntattInntekt
        get() = uforeOpptj.antattInntekt

    @get:Transient
    val reguleringBelop
        get() = lonnsvekstReg.belop

    @get:Transient
    val reguleringDato
        get() = lonnsvekstReg.dato

    @get:Transient
    override val fields
        get() = setOf(::datoFom, ::datoTom, ::belop, ::beholdningstype, ::status, ::grunnlag,
                ::grunnlagAvkortet, ::innskudd, ::inntektsar, ::inntektsgrunnlag, ::forstegangstjenesteAr,
                ::ordinareDagpenger, ::dagpengerAr, ::dagpengerFisker, ::omsorgAr, ::omsorgBelop, ::omsorgInnskudd,
                ::uforeBelop, ::uforeAr, ::uforegrad, ::uforeYrkesskadegrad, ::uforeAntattInntektYrke, ::uforeYrkesskade,
                ::uforeUforetrygd, ::uforeUforeAr, ::uforeAntattInntekt, ::reguleringBelop, ::reguleringDato)
}