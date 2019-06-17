package no.nav.pensjon.innsyn.domain.map;

import no.nav.pensjon.innsyn.domain.Inntekt;
import no.nav.pensjon.innsyn.sink.CellValueSetter;

public class InntektRowFiller {

    public static void setCellValues(CellValueSetter sink, Inntekt source) {
        int index = 0;
        sink.setCellValue(index++, source.getType());
        sink.setCellValue(index++, source.getStatus());
        sink.setCellValue(index++, source.getInntektsar());
        sink.setCellValue(index++, source.getBelop());
        sink.setCellValue(index++, source.getRapportdato());
        sink.setCellValue(index, source.getKilde());
    }

    private InntektRowFiller() {
    }
}
