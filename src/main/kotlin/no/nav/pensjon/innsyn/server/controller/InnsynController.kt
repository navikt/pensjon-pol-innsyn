package no.nav.pensjon.innsyn.server.controller

import no.nav.pensjon.innsyn.main.WorksheetProducer.producePOPPWorksheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.springframework.http.HttpHeaders.CONTENT_DISPOSITION
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController
import java.text.SimpleDateFormat
import java.util.*

@RestController("/innsyn")
class InnsynController {

    @GetMapping("/POPP", produces = [CONTENT_TYPE_EXCEL])
    fun getInnsyn(@RequestHeader("fnr") fnr: String): ResponseEntity<XSSFWorkbook> =
        ResponseEntity.ok(producePOPPWorksheet(fnr)).apply {
            headers.set(CONTENT_DISPOSITION, contentDisposition)
        }

    companion object {
        private const val FILE_NAME = "innsyn.%s.xlsx"
        private const val CONTENT_TYPE_EXCEL = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"
        private val DATE_FORMAT = SimpleDateFormat("yyyy-MM-dd")
        private val contentDisposition: String
            get() = "attachment; filename=${FILE_NAME.format(DATE_FORMAT.format(Date()))}"
    }
}