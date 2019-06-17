package no.nav.pensjon.innsyn.domain.map;

import no.nav.pensjon.innsyn.domain.Inntekt;
import no.nav.pensjon.innsyn.domain.source.HardcodedInntekt;
import no.nav.pensjon.innsyn.sink.CellValueSetter;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class InntektRowFillerTest {

    @Test
    void setCellValues() {
        var sink = mock(CellValueSetter.class);
        Inntekt source = new HardcodedInntekt().getEntities().get(0);

        InntektRowFiller.setCellValues(sink, source);

        verify(sink, times(1)).setCellValue(0, "type");
        verify(sink, times(1)).setCellValue(1, "status");
        verify(sink, times(1)).setCellValue(2, 2019);
        verify(sink, times(1)).setCellValue(3, 123456.78d);
        verify(sink, times(1)).setCellValue(4, "rapportdato");
        verify(sink, times(1)).setCellValue(5, "kilde");
    }
}
