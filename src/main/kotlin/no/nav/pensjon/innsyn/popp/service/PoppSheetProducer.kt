package no.nav.pensjon.innsyn.popp.service

import no.nav.pensjon.innsyn.common.service.SheetFiller
import no.nav.pensjon.innsyn.popp.domain.container.PoppContainer
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.springframework.stereotype.Service

@Service
class PoppSheetProducer(private val containers: List<PoppContainer<*>>) {
    fun produceWorksheet(pid: Int) = XSSFWorkbook().apply {
        containers.map { SheetFiller(it) }.forEach {
            it.populateSheet(pid, this)
        }
    }
}