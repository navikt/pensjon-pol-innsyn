package no.nav.pensjon.innsyn.service.map

import no.nav.pensjon.innsyn.domain.*
import no.nav.pensjon.innsyn.domain.source.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*

class DomainRowFillerTest {
    @Test
    fun `Sets Beholdning values`() {
        val sink = mock(CellValueSetter::class.java)
        val source: Beholdning = DomainObjects.beholdning.first()
        DomainRowFiller(Beholdning::class).setCellValues(sink, source)
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
        val source: Dagpenger = DomainObjects.dagpenger.first()
        DomainRowFiller(Dagpenger::class).setCellValues(sink, source)
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
        val source: Forstegangstjeneste = DomainObjects.forstegangstjeneste.first()
        DomainRowFiller(Forstegangstjeneste::class).setCellValues(sink, source)
        verify(sink, times(1)).setCellValue(0, "tjenestestart")
        verify(sink, times(1)).setCellValue(1, "dimittert")
        verify(sink, times(1)).setCellValue(2, "rapporttype")
        verify(sink, times(1)).setCellValue(3, "status")
        verify(sink, times(1)).setCellValue(4, "kilde")
    }

    @Test
    fun `Sets FppAfp values`() {
        val sink = mock(CellValueSetter::class.java)
        val source: FppAfp = DomainObjects.fppAfp.first()
        DomainRowFiller(FppAfp::class).setCellValues(sink, source)
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
        val source: Inntekt = DomainObjects.inntekt.first()
        DomainRowFiller(Inntekt::class).setCellValues(sink, source)
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
        val source: Omsorg = DomainObjects.omsorg.first()
        DomainRowFiller(Omsorg::class).setCellValues(sink, source)
        verify(sink, times(1)).setCellValue(0, 2018.0)
        verify(sink, times(1)).setCellValue(1, "kilde1")
        verify(sink, times(1)).setCellValue(2, "type1")
        verify(sink, times(1)).setCellValue(3, "status1")
    }

    @Test
    fun `Sets Opptjening values`() {
        val sink = mock(CellValueSetter::class.java)
        val source: Opptjening = DomainObjects.opptjening.first()
        DomainRowFiller(Opptjening::class).setCellValues(sink, source)
        verify(sink, times(1)).setCellValue(0, "type")
        verify(sink, times(1)).setCellValue(1, "status")
        verify(sink, times(1)).setCellValue(2, 2019.0)
        verify(sink, times(1)).setCellValue(3, 123456.78)
        verify(sink, times(1)).setCellValue(4, 12.34)
        verify(sink, times(1)).setCellValue(5, 15.75)
    }
}