package no.nav.pensjon.innsyn.domain.map;

import no.nav.pensjon.innsyn.domain.Omsorg;
import no.nav.pensjon.innsyn.sink.CellValueSetter;

public class OmsorgRowFiller {

    public static void setCellValues(CellValueSetter sink, Omsorg source) {
        int index = 0;
        sink.setCellValue(index++, source.getAr());
        sink.setCellValue(index++, source.getKilde());
        sink.setCellValue(index++, source.getType());
        sink.setCellValue(index, source.getStatus());
    }

    private OmsorgRowFiller() {
    }
}
