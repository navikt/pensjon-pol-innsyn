package no.nav.pensjon.innsyn.service.map

import no.nav.pensjon.innsyn.domain.popp.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*

class DomainRowFillerTest {
    @Test
    fun `Sets Beholdning values`() {
        val sink = mock(CellValueSetter::class.java)
        val source: Beholdning = PoppObjects.beholdning.first()
        DomainRowFiller<Beholdning>().setCellValues(sink, source)
        verify(sink, times(1)).setCellValue(0, "01.01.01")
        verify(sink, times(1)).setCellValue(1, "31.12.29")
        verify(sink, times(1)).setCellValue(2, 1.23)
        verify(sink, times(1)).setCellValue(3, "beholdningstype")
        verify(sink, times(1)).setCellValue(4, "status")
        verify(sink, times(1)).setCellValue(5, 2.34)
        verify(sink, times(1)).setCellValue(6, 3.45)
        verify(sink, times(1)).setCellValue(7, 4.56)
        verify(sink, times(1)).setCellValue(8, 2011.0)
        verify(sink, times(1)).setCellValue(9, 5.67)
        verify(sink, times(1)).setCellValue(10, 2012.0)
        verify(sink, times(1)).setCellValue(11, 6.78)
        verify(sink, times(1)).setCellValue(12, 2013.0)
        verify(sink, times(1)).setCellValue(13, 7.89)
        verify(sink, times(1)).setCellValue(14, 2014.0)
        verify(sink, times(1)).setCellValue(15, 8.90)
        verify(sink, times(1)).setCellValue(16, 9.01)
        verify(sink, times(1)).setCellValue(17, 10.12)
        verify(sink, times(1)).setCellValue(18, 2015.0)
        verify(sink, times(1)).setCellValue(19, 11.23)
        verify(sink, times(1)).setCellValue(20, 12.34)
        verify(sink, times(1)).setCellValue(21, 13.45)
        verify(sink, times(1)).setCellValue(22, true)
        verify(sink, times(1)).setCellValue(23, false)
        verify(sink, times(1)).setCellValue(24, true)
        verify(sink, times(1)).setCellValue(25, 14.56)
        verify(sink, times(1)).setCellValue(26, 15.67)
        verify(sink, times(1)).setCellValue(27, "15.06.15")
    }

    @Test
    fun `Sets Dagpenger values`() {
        val sink = mock(CellValueSetter::class.java)
        val source: Dagpenger = PoppObjects.dagpenger.first()
        DomainRowFiller<Dagpenger>().setCellValues(sink, source)
        verify(sink, times(1)).setCellValue(0, 123456.78)
        verify(sink, times(1)).setCellValue(1, 123456.78)
        verify(sink, times(1)).setCellValue(2, 123456.78)
        verify(sink, times(1)).setCellValue(3, 123456.78)
        verify(sink, times(1)).setCellValue(4, 2019.0)
        verify(sink, times(1)).setCellValue(5, "kilde")
        verify(sink, times(1)).setCellValue(6, "status")
        verify(sink, times(1)).setCellValue(7, "type")
        verify(sink, times(1)).setCellValue(8, "rapporttype")
    }

    @Test
    fun `Sets Forstegangstjeneste values`() {
        val sink = mock(CellValueSetter::class.java)
        val source: Forstegangstjeneste = PoppObjects.forstegangstjeneste.first()
        DomainRowFiller<Forstegangstjeneste>().setCellValues(sink, source)
        verify(sink, times(1)).setCellValue(0, "tjenestestart")
        verify(sink, times(1)).setCellValue(1, "dimittert")
        verify(sink, times(1)).setCellValue(2, "rapporttype")
        verify(sink, times(1)).setCellValue(3, "status")
        verify(sink, times(1)).setCellValue(4, "kilde")
    }

    @Test
    fun `Sets FppAfp values`() {
        val sink = mock(CellValueSetter::class.java)
        val source: FppAfp = PoppObjects.fppAfp.first()
        DomainRowFiller<FppAfp>().setCellValues(sink, source)
        verify(sink, times(1)).setCellValue(0, "status")
        verify(sink, times(1)).setCellValue(1, 123456.78)
        verify(sink, times(1)).setCellValue(2, "gjelderFom")
        verify(sink, times(1)).setCellValue(3, "gjelderTom")
        verify(sink, times(1)).setCellValue(4, 123456.78)
        verify(sink, times(1)).setCellValue(5, "afpType")
    }

    @Test
    fun `Sets Inntekt values`() {
        val sink = mock(CellValueSetter::class.java)
        val source: Inntekt = PoppObjects.inntekt.first()
        DomainRowFiller<Inntekt>().setCellValues(sink, source)
        verify(sink, times(1)).setCellValue(0, "type")
        verify(sink, times(1)).setCellValue(1, "status")
        verify(sink, times(1)).setCellValue(2, 2019.0)
        verify(sink, times(1)).setCellValue(3, 123456.78)
        verify(sink, times(1)).setCellValue(4, "rapportdato")
        verify(sink, times(1)).setCellValue(5, "kilde")
    }

    @Test
    fun `Sets Omsorg values`() {
        val sink = mock(CellValueSetter::class.java)
        val source: Omsorg = PoppObjects.omsorg.first()
        DomainRowFiller<Omsorg>().setCellValues(sink, source)
        verify(sink, times(1)).setCellValue(0, 2018.0)
        verify(sink, times(1)).setCellValue(1, "kilde1")
        verify(sink, times(1)).setCellValue(2, "type1")
        verify(sink, times(1)).setCellValue(3, "status1")
    }

    @Test
    fun `Sets Opptjening values`() {
        val sink = mock(CellValueSetter::class.java)
        val source: Opptjening = PoppObjects.opptjening.first()
        DomainRowFiller<Opptjening>().setCellValues(sink, source)
        verify(sink, times(1)).setCellValue(0, "type")
        verify(sink, times(1)).setCellValue(1, "status")
        verify(sink, times(1)).setCellValue(2, 2019.0)
        verify(sink, times(1)).setCellValue(3, 123456.78)
        verify(sink, times(1)).setCellValue(4, 12.34)
        verify(sink, times(1)).setCellValue(5, 15.75)
    }
}