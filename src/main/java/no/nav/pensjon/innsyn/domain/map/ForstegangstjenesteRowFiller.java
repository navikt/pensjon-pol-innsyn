package no.nav.pensjon.innsyn.domain.map;

import no.nav.pensjon.innsyn.domain.Forstegangstjeneste;
import no.nav.pensjon.innsyn.sink.CellValueSetter;

public class ForstegangstjenesteRowFiller {

    public static void setCellValues(CellValueSetter sink, Forstegangstjeneste source) {
        int index = 0;
        sink.setCellValue(index++, source.getTjenestestart());
        sink.setCellValue(index++, source.getDimittert());
        sink.setCellValue(index++, source.getRapporttype());
        sink.setCellValue(index++, source.getStatus());
        sink.setCellValue(index, source.getKilde());
    }

    private ForstegangstjenesteRowFiller() {
    }
}
