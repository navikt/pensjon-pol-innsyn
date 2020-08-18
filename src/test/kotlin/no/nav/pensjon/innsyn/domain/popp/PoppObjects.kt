package no.nav.pensjon.innsyn.domain.popp

import no.nav.pensjon.innsyn.domain.popp.support.*
import java.time.LocalDate

object PoppObjects {
    private val rapporttype1 = RapportType(
            id = "k_rapport_t",
            dekode = "Rapporttype 1"
    )

    private val kildetype1 = KildeType(
            id = "k_kilde_t",
            dekode = "Kildetype 1"
    )

    val beholdning = listOf(Beholdning(
            personId = 1,
            datoFom = LocalDate.of(2019,11,1),
            datoTom = LocalDate.of(2019,12,31),
            belop = 1.23,
            grunnlag = 2.34,
            grunnlagAvkortet = 3.45,
            innskudd = 4.56,
            beholdningType = BeholdningType(
                    id = "k_beholdning_t",
                    dekode = "Beholdningstype 1"
            ),
            beholdningStatus = BeholdningStatus(
                    id = "k_beholdning_s",
                    dekode = "Beholdningsstatus 1"
            ),
            inntektOpptj = InntektOpptj(
                    id = 1,
                    ar = 1,
                    belop = 1.23
            ),
            fTjenOpptj = FTjenOpptj(
                    id = 1,
                    ar = 2019
            ),
            dagpengerOpptj = DagpengerOpptj(
                    id = 1,
                    belopOrdinar = 1.23,
                    ar = 2019,
                    belopFiskere = 2.34
            ),
            omsorgOpptj = OmsorgOpptj(
                    id = 1,
                    ar = 2019,
                    belop = 1.23,
                    inskudd = 2.34
            ),
            uforeOpptj = UforeOpptj(
                    id = 1,
                    belop = 1.23,
                    ar = 2019,
                    ufg = 2.34,
                    yug = 3.45,
                    antattInntektYrke = 4.56,
                    yrkesskade = true,
                    uforetrygd = false,
                    uforear = true,
                    antattInntekt = 7.89
            ),
            lonnsvekstReg = LonnsvekstReg(
                    id = 1,
                    belop = 1.23,
                    dato = LocalDate.of(2019,12,31)
            )))

    val dagpenger = listOf(Dagpenger(
            personId = 1,
            ferietillegg = 1.23,
            barnetillegg = 2.34,
            dagpenger = 3.45,
            uavkortetGrunnlag = 4.56,
            arDagpengerUtbetalt = 2019,
            kildeType = kildetype1,
            dagpengerStatus = DagpengerStatus(
                    id = "k_dagpenger_s",
                    dekode = "Dagpengerstatus 1"
            ),
            dagpengerType = DagpengerType(
                    id = "k_dagpenger_t",
                    dekode = "Dagpengertype 1"
            ),
            rapportType = rapporttype1
    ))

    val forstegangstjeneste = listOf(Forstegangstjeneste(
            personId = 1,
            tjenestestart = LocalDate.of(2019,12,31),
            dimittert = LocalDate.of(2019, 12, 31),
            rapportType = rapporttype1,
            fTjenStatus = FTjenStatus(
                    id = "k_f_tjen_tot_s",
                    dekode = "1.gangstj.status 1"
            ),
            kildeType = kildetype1
    ))

    val fppAfp = listOf(FppAfp(
            personId = 1,
            fppAfpStatus = FppAfpStatus(
                    id = "1",
                    dekode = "FPP-AFP-status 1"
            ),
            fppAfp = 123.45,
            gjelderFom = LocalDate.of(2001,1,1),
            gjelderTom = LocalDate.of(2029,12,31),
            afpPensjonsgrad = 32.1,
            afpType = "AFP 1"
    ))

    val inntekt = listOf(Inntekt(
            personId = 1,
            inntektType = InntektType(
                    id = "k_inntekt_t",
                    dekode = "Inntektstype 1"
            ),
            inntektStatus = InntektStatus(
                    id = "k_inntekt_status",
                    dekode = "Inntektsstatus 1"
            ),
            inntektsar = 2019,
            belop = 1.23,
            rapportdato = LocalDate.of(2019,12,31),
            kildeType = kildetype1
    ))

    val omsorg = listOf(
            Omsorg(
                    personId = 1,
                    ar = 2019,
                    kildeType = kildetype1,
                    omsorgType = OmsorgType("k_omsorg_t", "Omsorgstype 1"),
                    omsorgStatus = OmsorgStatus("k_omsorg_s", "Omsorgsstatus 1")
            )
//            ,
//            Omsorg(
//                    personId = 2,
//                    ar = 2019,
//                    kildeType = KildeType("kilde2", "kilde2"),
//                    omsorgType = OmsorgType("type2", "type2"),
//                    omsorgStatus = OmsorgStatus("status2", "status2")
//            )
    )

    val opptjening = listOf(Opptjening(
            personId = 1,
            opptjeningType =  OpptjeningType("k_opptjn_t", "Opptjeningstype 1"),
            opptjeningStatus = OpptjeningStatus("k_opptjn_status", "Opptjeningsstatus 1"),
            opptjeningsar = 2019,
            pensjonsgivendeInntekt = 1.23,
            poeng = 2.34,
            uforegrad = 3.45))
}