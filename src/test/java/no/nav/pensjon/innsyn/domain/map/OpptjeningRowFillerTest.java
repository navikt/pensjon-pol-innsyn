package no.nav.pensjon.innsyn.domain.map;

import no.nav.pensjon.innsyn.domain.Opptjening;
import no.nav.pensjon.innsyn.domain.source.HardcodedOpptjening;
import no.nav.pensjon.innsyn.sink.CellValueSetter;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class OpptjeningRowFillerTest {

    @Test
    void setCellValues() {
        var sink = mock(CellValueSetter.class);
        Opptjening source = new HardcodedOpptjening().getEntities().get(0);

        OpptjeningRowFiller.setCellValues(sink, source);

        verify(sink, times(1)).setCellValue(0, "type");
        verify(sink, times(1)).setCellValue(1, "status");
        verify(sink, times(1)).setCellValue(2, 2019);
        verify(sink, times(1)).setCellValue(3, 123456.78d);
        verify(sink, times(1)).setCellValue(4, 12.34d);
        verify(sink, times(1)).setCellValue(5, 15.75d);
    }
}
