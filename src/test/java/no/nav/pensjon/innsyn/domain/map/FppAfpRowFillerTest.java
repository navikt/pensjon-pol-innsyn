package no.nav.pensjon.innsyn.domain.map;

import no.nav.pensjon.innsyn.domain.FppAfp;
import no.nav.pensjon.innsyn.domain.source.HardcodedFppAfp;
import no.nav.pensjon.innsyn.sink.CellValueSetter;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class FppAfpRowFillerTest {

    @Test
    void setCellValues() {
        var sink = mock(CellValueSetter.class);
        FppAfp source = new HardcodedFppAfp().getEntities().get(0);

        FppAfpRowFiller.setCellValues(sink, source);

        verify(sink, times(1)).setCellValue(0, "status");
        verify(sink, times(1)).setCellValue(1, 123456.78d);
        verify(sink, times(1)).setCellValue(2, "gjelderFom");
        verify(sink, times(1)).setCellValue(3, "gjelderTom");
        verify(sink, times(1)).setCellValue(4, 123456.78d);
        verify(sink, times(1)).setCellValue(5, "afpType");
    }
}
