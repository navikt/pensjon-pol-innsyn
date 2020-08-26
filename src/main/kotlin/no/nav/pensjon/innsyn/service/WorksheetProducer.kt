package no.nav.pensjon.innsyn.service

import no.nav.pensjon.innsyn.domain.popp.container.PoppContainer
import no.nav.pensjon.innsyn.domain.tp.container.TpContainer
import no.nav.pensjon.innsyn.service.map.SheetFiller
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.springframework.stereotype.Service

@Service
class WorksheetProducer(
        val poppContainers: List<PoppContainer<*>>,
        val tpContainers: List<TpContainer<*>>
) {
    fun producePOPPWorksheet(pid: Int) = XSSFWorkbook().apply {
        poppContainers.map { SheetFiller(it) }.apply {
        }.forEach {
            it.populateSheet(pid, this)
        }
    }

    fun produceTPWorksheet(pid: Int) = XSSFWorkbook().apply {
        tpContainers.map { SheetFiller(it) }.apply {
        }.forEach {
            it.populateSheet(pid, this)
        }
    }
}