package no.nav.pensjon.innsyn.domain.source

import no.nav.pensjon.innsyn.domain.*

object DomainObjects {
    val beholdning = listOf(Beholdning(
            datoFom = "01.01.01",
            datoTom = "31.12.29",
            belop = 1.23,
            beholdningstype = "beholdningstype",
            status = "status",
            grunnlag = 2.34,
            grunnlagAvkortet = 3.45,
            innskudd = 4.56,
            inntektsar = 2011,
            inntektsgrunnlag = 5.67,
            forstegangstjenesteAr = 2012,
            ordinareDagpenger = 6.78,
            dagpengerAr = 2013,
            dagpengerFisker = 7.89,
            omsorgAr = 2014,
            omsorgBelop = 8.90,
            omsorgInnskudd = 9.01,
            uforeBelop = 10.12,
            uforeAr = 2015,
            uforegrad = 11.23,
            uforeYrkesskadegrad = 12.34,
            uforeAntattInntektYrke = 13.45,
            uforeYrkesskade = true,
            uforeUforetrygd = false,
            uforeUforeAr = true,
            uforeAntattInntekt = 14.56,
            reguleringBelop = 15.67,
            reguleringDato = "15.06.15"))

    val dagpenger = listOf(Dagpenger(
            ferietillegg = 123456.78,
            barnetillegg = 123456.78,
            dagpenger = 123456.78,
            uavkortetGrunnlag = 123456.78,
            arDagpengerUtbetalt = 2019,
            kilde = "kilde",
            status = "status",
            type = "type",
            rapporttype = "rapporttype"))

    val forstegangstjeneste = listOf(Forstegangstjeneste(
            tjenestestart = "tjenestestart",
            dimittert = "dimittert",
            rapporttype = "rapporttype",
            status = "status",
            kilde = "kilde"))

    val fppAfp = listOf(FppAfp(
            status = "status",
            fppAfp = 123456.78,
            gjelderFom = "gjelderFom",
            gjelderTom = "gjelderTom",
            afpPensjonsgrad = 123456.78,
            afpType = "afpType"))

    val inntekt = listOf(Inntekt(
            type = "type",
            status = "status",
            inntektsar = 2019,
            belop = 123456.78,
            rapportdato = "rapportdato",
            kilde = "kilde"))

    val omsorg = listOf(
            Omsorg(ar = 2018, kilde = "kilde1", type = "type1", status = "status1"),
            Omsorg(ar = 2019, kilde = "kilde2", type = "type2", status = "status2"))

    val opptjening = listOf(Opptjening(
            type = "type",
            status = "status",
            opptjeningsar = 2019,
            pensjonsgivendeInntekt = 123456.78,
            poeng = 12.34,
            uforegrad = 15.75))
}