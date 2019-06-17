package no.nav.pensjon.innsyn.domain.map;

import no.nav.pensjon.innsyn.domain.Opptjening;
import no.nav.pensjon.innsyn.sink.CellValueSetter;

public class OpptjeningRowFiller {

    public static void setCellValues(CellValueSetter sink, Opptjening source) {
        int index = 0;
        sink.setCellValue(index++, source.getType());
        sink.setCellValue(index++, source.getStatus());
        sink.setCellValue(index++, source.getOpptjeningsar());
        sink.setCellValue(index++, source.getPensjonsgivendeInntekt());
        sink.setCellValue(index++, source.getPoeng());
        sink.setCellValue(index, source.getUforegrad());
    }

    private OpptjeningRowFiller() {
    }
}
