package no.nav.pensjon.innsyn.domain.map;

import no.nav.pensjon.innsyn.domain.FppAfp;
import no.nav.pensjon.innsyn.sink.CellValueSetter;

public class FppAfpRowFiller {

    public static void setCellValues(CellValueSetter sink, FppAfp source) {
        int index = 0;
        sink.setCellValue(index++, source.getStatus());
        sink.setCellValue(index++, source.getFppAfp());
        sink.setCellValue(index++, source.getGjelderFom());
        sink.setCellValue(index++, source.getGjelderTom());
        sink.setCellValue(index++, source.getAfpPensjonsgrad());
        sink.setCellValue(index, source.getAfpType());
    }
}
