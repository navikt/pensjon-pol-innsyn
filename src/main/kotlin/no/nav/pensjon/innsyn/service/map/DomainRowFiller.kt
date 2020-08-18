package no.nav.pensjon.innsyn.service.map

import no.nav.pensjon.innsyn.domain.Domain
import java.util.*

class DomainRowFiller<T : Domain> {
    fun setCellValues(sink: CellValueSetter, source: T) =
            source.fields.forEachIndexed { i, p ->
                when (val v = p.call()) {
                    is String -> sink.setCellValue(i, v)
                    is Double -> sink.setCellValue(i, v)
                    is Int -> sink.setCellValue(i, v.toDouble())
                    is Date -> sink.setCellValue(i, v)
                    is Boolean -> sink.setCellValue(i, v)
                    else -> throw RuntimeException()
                }
            }
}