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

        verify(sink, times(1)).setCellValue(0, "datoFom");
        verify(sink, times(1)).setCellValue(1, "datoTom");
        verify(sink, times(1)).setCellValue(2, 123456.78d);
        verify(sink, times(1)).setCellValue(3, "beholdningstype");
        verify(sink, times(1)).setCellValue(4, "status");
        verify(sink, times(1)).setCellValue(5, 123456.78d);
        verify(sink, times(1)).setCellValue(6, 123456.78d);
        verify(sink, times(1)).setCellValue(7, 123456.78d);
        verify(sink, times(1)).setCellValue(8, 2019);
        verify(sink, times(1)).setCellValue(9, 123456.78d);
        verify(sink, times(1)).setCellValue(10, 2019);
        verify(sink, times(1)).setCellValue(11, "ordinareDagpenger");
        verify(sink, times(1)).setCellValue(12, 2019);
        verify(sink, times(1)).setCellValue(13, "dagpengerFisker");
        verify(sink, times(1)).setCellValue(14, 2019);
        verify(sink, times(1)).setCellValue(15, 123456.78d);
        verify(sink, times(1)).setCellValue(16, 123456.78d);
        verify(sink, times(1)).setCellValue(17, 123456.78d);
        verify(sink, times(1)).setCellValue(18, 2019);
        verify(sink, times(1)).setCellValue(19, "uforegrad");
        verify(sink, times(1)).setCellValue(20, "uforeYrkesskadegrad");
        verify(sink, times(1)).setCellValue(21, "uforeAntattInntektYrke");
        verify(sink, times(1)).setCellValue(22, "uforeYrkesskade");
        verify(sink, times(1)).setCellValue(23, "uforeUforetrygd");
        verify(sink, times(1)).setCellValue(24, 2019);
        verify(sink, times(1)).setCellValue(25, 123456.78d);
        verify(sink, times(1)).setCellValue(26, 123456.78d);
        verify(sink, times(1)).setCellValue(27, "reguleringDato");
    }
}
