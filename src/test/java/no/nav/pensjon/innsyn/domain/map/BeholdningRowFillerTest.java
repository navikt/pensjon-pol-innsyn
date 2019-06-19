package no.nav.pensjon.innsyn.domain.map;

import no.nav.pensjon.innsyn.domain.Beholdning;
import no.nav.pensjon.innsyn.domain.source.HardcodedBeholdning;
import no.nav.pensjon.innsyn.sink.CellValueSetter;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class BeholdningRowFillerTest {

    @Test
    void setCellValues() {
        var sink = mock(CellValueSetter.class);
        Beholdning source = new HardcodedBeholdning().getEntities().get(0);

        BeholdningRowFiller.setCellValues(sink, source);

        verify(sink, times(1)).setCellValue(0, "01.01.01");
        verify(sink, times(1)).setCellValue(1, "31.12.29");
        verify(sink, times(1)).setCellValue(2, 1.23d);
        verify(sink, times(1)).setCellValue(3, "beholdningstype");
        verify(sink, times(1)).setCellValue(4, "status");
        verify(sink, times(1)).setCellValue(5, 2.34d);
        verify(sink, times(1)).setCellValue(6, 3.45d);
        verify(sink, times(1)).setCellValue(7, 4.56d);
        verify(sink, times(1)).setCellValue(8, 2011);
        verify(sink, times(1)).setCellValue(9, 5.67d);
        verify(sink, times(1)).setCellValue(10, 2012);
        verify(sink, times(1)).setCellValue(11, 6.78d);
        verify(sink, times(1)).setCellValue(12, 2013);
        verify(sink, times(1)).setCellValue(13, 7.89d);
        verify(sink, times(1)).setCellValue(14, 2014);
        verify(sink, times(1)).setCellValue(15, 8.90d);
        verify(sink, times(1)).setCellValue(16, 9.01d);
        verify(sink, times(1)).setCellValue(17, 10.12d);
        verify(sink, times(1)).setCellValue(18, 2015);
        verify(sink, times(1)).setCellValue(19, 11.23d);
        verify(sink, times(1)).setCellValue(20, 12.34d);
        verify(sink, times(1)).setCellValue(21, 13.45d);
        verify(sink, times(1)).setCellValue(22, true);
        verify(sink, times(1)).setCellValue(23, false);
        verify(sink, times(1)).setCellValue(24, true);
        verify(sink, times(1)).setCellValue(25, 14.56d);
        verify(sink, times(1)).setCellValue(26, 15.67d);
        verify(sink, times(1)).setCellValue(27, "15.06.15");
    }
}
