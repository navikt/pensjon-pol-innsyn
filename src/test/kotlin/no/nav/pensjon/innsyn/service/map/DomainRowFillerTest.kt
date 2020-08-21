package no.nav.pensjon.innsyn.service.map

import no.nav.pensjon.innsyn.domain.popp.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import org.springframework.context.annotation.Profile
import java.time.LocalDate

class DomainRowFillerTest {
    @Test
    fun `Sets Beholdning values`() {
        val sink = mock(CellValueSetter::class.java)
        val source: Beholdning = PoppObjects.beholdning.first()
        DomainRowFiller<Beholdning>().setCellValues(sink, source)
        verify(sink, times(1)).setCellValue(0, LocalDate.of(2019,11,1))
        verify(sink, times(1)).setCellValue(1, LocalDate.of(2019,12,31))
        verify(sink, times(1)).setCellValue(2, 1.23)
        verify(sink, times(1)).setCellValue(3, "Beholdningstype 1")
        verify(sink, times(1)).setCellValue(4, "Beholdningsstatus 1")
        verify(sink, times(1)).setCellValue(5, 2.34)
        verify(sink, times(1)).setCellValue(6, 3.45)
        verify(sink, times(1)).setCellValue(7, 4.56)
        verify(sink, times(1)).setCellValue(8, 1.0)
        verify(sink, times(1)).setCellValue(9, 1.23)
        verify(sink, times(1)).setCellValue(10, 2019.0)
        verify(sink, times(1)).setCellValue(11, 1.23)
        verify(sink, times(1)).setCellValue(12, 2019.0)
        verify(sink, times(1)).setCellValue(13, 2.34)
        verify(sink, times(1)).setCellValue(14, 2019.0)
        verify(sink, times(1)).setCellValue(15, 1.23)
        verify(sink, times(1)).setCellValue(16, 2.34)
        verify(sink, times(1)).setCellValue(17, 1.23)
        verify(sink, times(1)).setCellValue(18, 2019.0)
        verify(sink, times(1)).setCellValue(19, 2.34)
        verify(sink, times(1)).setCellValue(20, 3.45)
        verify(sink, times(1)).setCellValue(21, 4.56)
        verify(sink, times(1)).setCellValue(22, true)
        verify(sink, times(1)).setCellValue(23, false)
        verify(sink, times(1)).setCellValue(24, true)
        verify(sink, times(1)).setCellValue(25, 7.89)
        verify(sink, times(1)).setCellValue(26, 1.23)
        verify(sink, times(1)).setCellValue(27, LocalDate.of(2019,12,31))
    }

    @Test
    fun `Sets Dagpenger values`() {
        val sink = mock(CellValueSetter::class.java)
        val source: Dagpenger = PoppObjects.dagpenger.first()
        DomainRowFiller<Dagpenger>().setCellValues(sink, source)
        verify(sink, times(1)).setCellValue(0, 1.23)
        verify(sink, times(1)).setCellValue(1, 2.34)
        verify(sink, times(1)).setCellValue(2, 3.45)
        verify(sink, times(1)).setCellValue(3, 4.56)
        verify(sink, times(1)).setCellValue(4, 2019.0)
        verify(sink, times(1)).setCellValue(5, "Kildetype 1")
        verify(sink, times(1)).setCellValue(6, "Dagpengerstatus 1")
        verify(sink, times(1)).setCellValue(7, "Dagpengertype 1")
        verify(sink, times(1)).setCellValue(8, "Rapporttype 1")
    }

    @Test
    fun `Sets Forstegangstjeneste values`() {
        val sink = mock(CellValueSetter::class.java)
        val source: Forstegangstjeneste = PoppObjects.forstegangstjeneste.first()
        DomainRowFiller<Forstegangstjeneste>().setCellValues(sink, source)
        verify(sink, times(1)).setCellValue(0, LocalDate.of(2019,12,31))
        verify(sink, times(1)).setCellValue(1, LocalDate.of(2019,12,31))
        verify(sink, times(1)).setCellValue(2, "Rapporttype 1")
        verify(sink, times(1)).setCellValue(3, "1.gangstj.status 1")
        verify(sink, times(1)).setCellValue(4, "Kildetype 1")
    }

    @Test
    fun `Sets FppAfp values`() {
        val sink = mock(CellValueSetter::class.java)
        val source: FppAfp = PoppObjects.fppAfp.first()
        DomainRowFiller<FppAfp>().setCellValues(sink, source)
        verify(sink, times(1)).setCellValue(0, "FPP-AFP-status 1")
        verify(sink, times(1)).setCellValue(1, 123.45)
        verify(sink, times(1)).setCellValue(2, LocalDate.of(2001,1,1))
        verify(sink, times(1)).setCellValue(3, LocalDate.of(2029,12,31))
        verify(sink, times(1)).setCellValue(4, 32.1)
        verify(sink, times(1)).setCellValue(5, "AFP 1")
    }

    @Test
    fun `Sets Inntekt values`() {
        val sink = mock(CellValueSetter::class.java)
        val source: Inntekt = PoppObjects.inntekt.first()
        DomainRowFiller<Inntekt>().setCellValues(sink, source)
        verify(sink, times(1)).setCellValue(0, "Inntektstype 1")
        verify(sink, times(1)).setCellValue(1, "Inntektsstatus 1")
        verify(sink, times(1)).setCellValue(2, 2019.0)
        verify(sink, times(1)).setCellValue(3, 1.23)
        verify(sink, times(1)).setCellValue(4, LocalDate.of(2019,12,31))
        verify(sink, times(1)).setCellValue(5, "Kildetype 1")
    }

    @Test
    fun `Sets Omsorg values`() {
        val sink = mock(CellValueSetter::class.java)
        val source: Omsorg = PoppObjects.omsorg.first()
        DomainRowFiller<Omsorg>().setCellValues(sink, source)
        verify(sink, times(1)).setCellValue(0, 2019.0)
        verify(sink, times(1)).setCellValue(1, "Kildetype 1")
        verify(sink, times(1)).setCellValue(2, "Omsorgstype 1")
        verify(sink, times(1)).setCellValue(3, "Omsorgsstatus 1")
    }

    @Test
    fun `Sets Opptjening values`() {
        val sink = mock(CellValueSetter::class.java)
        val source: Opptjening = PoppObjects.opptjening.first()
        DomainRowFiller<Opptjening>().setCellValues(sink, source)
        verify(sink, times(1)).setCellValue(0, "Opptjeningstype 1")
        verify(sink, times(1)).setCellValue(1, "Opptjeningsstatus 1")
        verify(sink, times(1)).setCellValue(2, 2019.0)
        verify(sink, times(1)).setCellValue(3, 1.23)
        verify(sink, times(1)).setCellValue(4, 2.34)
        verify(sink, times(1)).setCellValue(5, 3.45)
    }
}