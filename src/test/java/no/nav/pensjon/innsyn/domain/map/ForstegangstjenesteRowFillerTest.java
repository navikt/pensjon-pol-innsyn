package no.nav.pensjon.innsyn.domain.map;

import no.nav.pensjon.innsyn.domain.Forstegangstjeneste;
import no.nav.pensjon.innsyn.domain.source.HardcodedForstegangstjeneste;
import no.nav.pensjon.innsyn.sink.CellValueSetter;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class ForstegangstjenesteRowFillerTest {

    @Test
    void setCellValues() {
        var sink = mock(CellValueSetter.class);
        Forstegangstjeneste source = new HardcodedForstegangstjeneste().getEntities().get(0);

        ForstegangstjenesteRowFiller.setCellValues(sink, source);

        verify(sink, times(1)).setCellValue(0, "tjenestestart");
        verify(sink, times(1)).setCellValue(1, "dimittert");
        verify(sink, times(1)).setCellValue(2, "rapporttype");
        verify(sink, times(1)).setCellValue(3, "status");
        verify(sink, times(1)).setCellValue(4, "kilde");
    }
}
