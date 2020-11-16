package no.nav.pensjon.innsyn.common.service

import io.mockk.mockk
import io.mockk.verifySequence
import no.nav.pensjon.innsyn.common.domain.Domain
import org.junit.jupiter.api.Test
import java.time.LocalDate

internal class DomainRowFillerTest{
    @Suppress("MemberVisibilityCanBePrivate")
    object TestDomainObject: Domain{
        const val a = 1.0
        const val b = "b"
        val c: LocalDate = LocalDate.of(1,1,1)

        override val fields = setOf(::a,::b,::c)
    }

    @Test
    fun `Sets all rows in order`(){
        val filler = DomainRowFiller<TestDomainObject>()
        val sink = mockk<RowFiller>(relaxed=true)

        filler.setCellValues(sink, TestDomainObject)
        verifySequence {
            sink.setCellValue(0,1.0)
            sink.setCellValue(1,"b")
            sink.setCellValue(2, LocalDate.of(1,1,1))
        }
    }
}