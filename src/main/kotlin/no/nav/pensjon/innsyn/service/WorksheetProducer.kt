package no.nav.pensjon.innsyn.service

import no.nav.pensjon.innsyn.service.map.SheetFiller
import no.nav.pensjon.innsyn.domain.popp.container.PoppContainer
import org.apache.poi.xssf.streaming.SXSSFWorkbook
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.springframework.stereotype.Service

@Service
class WorksheetProducer(
        vararg val poppContainers: PoppContainer<*>
) {
    fun producePOPPWorksheet(pid: Int) = XSSFWorkbook().apply {
        poppContainers.map { SheetFiller(it) }.apply {
        }.forEach {
            it.populateSheet(pid, this)
        }
    }
}