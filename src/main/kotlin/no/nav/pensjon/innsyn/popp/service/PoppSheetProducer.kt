package no.nav.pensjon.innsyn.popp.service

import no.nav.pensjon.innsyn.common.PersonNotFoundException
import no.nav.pensjon.innsyn.common.service.SheetFiller
import no.nav.pensjon.innsyn.popp.domain.container.PoppContainer
import no.nav.pensjon.innsyn.popp.repository.PersonRepository
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.springframework.stereotype.Service

@Service
class PoppSheetProducer(
        private val containers: List<PoppContainer<*>>,
        private val personRepository: PersonRepository
) {
    fun produceWorksheet(fnr: String) = personRepository.findByFnr(fnr)?.run {
        XSSFWorkbook().apply {
            containers.map { SheetFiller(it) }.forEach {
                it.populateSheet(personId, this)
            }
        }
    } ?: throw PersonNotFoundException()
}