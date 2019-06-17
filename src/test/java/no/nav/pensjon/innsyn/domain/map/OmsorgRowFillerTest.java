package no.nav.pensjon.innsyn.domain.map;

import no.nav.pensjon.innsyn.domain.Omsorg;
import no.nav.pensjon.innsyn.domain.source.HardcodedOmsorg;
import no.nav.pensjon.innsyn.sink.CellValueSetter;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class OmsorgRowFillerTest {

    @Test
    void setCellValues() {
        var sink = mock(CellValueSetter.class);
        Omsorg source = new HardcodedOmsorg().getEntities().get(0);

        OmsorgRowFiller.setCellValues(sink, source);

        verify(sink, times(1)).setCellValue(0, 2018);
        verify(sink, times(1)).setCellValue(1, "kilde1");
        verify(sink, times(1)).setCellValue(2, "type1");
        verify(sink, times(1)).setCellValue(3, "status1");
    }
}
