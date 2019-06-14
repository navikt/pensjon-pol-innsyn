package no.nav.pensjon.innsyn.domain.map;

import no.nav.pensjon.innsyn.domain.Beholdning;
import no.nav.pensjon.innsyn.sink.CellValueSetter;

public class BeholdningRowFiller {

    public static void setCellValues(CellValueSetter sink, Beholdning source) {
        int index = 0;
        sink.setCellValue(index++, source.getDatoFom());
        sink.setCellValue(index++, source.getDatoTom());
        sink.setCellValue(index++, source.getBelop());
        sink.setCellValue(index++, source.getBeholdningstype());
        sink.setCellValue(index++, source.getStatus());
        sink.setCellValue(index++, source.getGrunnlag());
        sink.setCellValue(index++, source.getGrunnlagAvkortet());
        sink.setCellValue(index++, source.getInnskudd());
        sink.setCellValue(index++, source.getInntektsar());
        sink.setCellValue(index++, source.getInntektsgrunnlag());
        sink.setCellValue(index++, source.getForstegangstjenesteAr());
        sink.setCellValue(index++, source.getOrdinareDagpenger());
        sink.setCellValue(index++, source.getDagpengerAr());
        sink.setCellValue(index++, source.getDagpengerFisker());
        sink.setCellValue(index++, source.getOmsorgAr());
        sink.setCellValue(index++, source.getOmsorgBelop());
        sink.setCellValue(index++, source.getOmsorgInnskudd());
        sink.setCellValue(index++, source.getUforeBelop());
        sink.setCellValue(index++, source.getUforeAr());
        sink.setCellValue(index++, source.getUforegrad());
        sink.setCellValue(index++, source.getUforeYrkesskadegrad());
        sink.setCellValue(index++, source.getUforeAntattInntektYrke());
        sink.setCellValue(index++, source.getUforeYrkesskade());
        sink.setCellValue(index++, source.getUforeUforetrygd());
        sink.setCellValue(index++, source.getUforeUforeAr());
        sink.setCellValue(index++, source.getUforeAntattInntekt());
        sink.setCellValue(index++, source.getReguleringBelop());
        sink.setCellValue(index, source.getReguleringDato());
    }
}
