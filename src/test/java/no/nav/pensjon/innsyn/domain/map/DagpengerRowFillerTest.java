package no.nav.pensjon.innsyn.domain.map;

import no.nav.pensjon.innsyn.domain.Dagpenger;
import no.nav.pensjon.innsyn.domain.source.HardcodedDagpenger;
import no.nav.pensjon.innsyn.sink.CellValueSetter;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class DagpengerRowFillerTest {

    @Test
    void setCellValues() {
        var sink = mock(CellValueSetter.class);
        Dagpenger source = new HardcodedDagpenger().getEntities().get(0);

        DagpengerRowFiller.setCellValues(sink, source);

        verify(sink, times(1)).setCellValue(0, 123456.78d);
        verify(sink, times(1)).setCellValue(1, 123456.78d);
        verify(sink, times(1)).setCellValue(2, 123456.78d);
        verify(sink, times(1)).setCellValue(3, 123456.78d);
        verify(sink, times(1)).setCellValue(4, 2019);
        verify(sink, times(1)).setCellValue(5, "kilde");
        verify(sink, times(1)).setCellValue(6, "status");
        verify(sink, times(1)).setCellValue(7, "type");
        verify(sink, times(1)).setCellValue(8, "rapporttype");
    }
}
