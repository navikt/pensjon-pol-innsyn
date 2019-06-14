package no.nav.pensjon.innsyn.domain.map;

import no.nav.pensjon.innsyn.domain.Dagpenger;
import no.nav.pensjon.innsyn.sink.CellValueSetter;

public class DagpengerRowFiller {

    public static void setCellValues(CellValueSetter sink, Dagpenger source) {
        int index = 0;
        sink.setCellValue(index++, source.getFerietillegg());
        sink.setCellValue(index++, source.getBarnetillegg());
        sink.setCellValue(index++, source.getDagpenger());
        sink.setCellValue(index++, source.getUavkortetGrunnlag());
        sink.setCellValue(index++, source.getArDagpengerUtbetalt());
        sink.setCellValue(index++, source.getKilde());
        sink.setCellValue(index++, source.getStatus());
        sink.setCellValue(index++, source.getType());
        sink.setCellValue(index, source.getRapporttype());
    }
}
